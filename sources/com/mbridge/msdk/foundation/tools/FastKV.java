package com.mbridge.msdk.foundation.tools;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private static final int[] TYPE_SIZE;
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private int dataEnd;
    private final Map<String, b> encoderMap;
    private z fastBuffer;
    private int invalidBytes;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;
    private final Map<String, h> data = new HashMap();
    private final Executor executor = new c0();
    private final ArrayList<d> invalids = new ArrayList<>();
    private final c logger = a0.f35735b;
    private boolean autoCommit = true;

    /* loaded from: classes5.dex */
    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private b[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith("/")) {
                str = str + '/';
            }
            this.path = str;
            this.name = str2;
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public FastKV build() {
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV = map.get(str);
            if (fastKV == null) {
                synchronized (Builder.class) {
                    try {
                        fastKV = map.get(str);
                        if (fastKV == null) {
                            fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                            map.put(str, fastKV);
                        }
                    } finally {
                    }
                }
            }
            return fastKV;
        }

        public Builder encoder(b[] bVarArr) {
            this.encoders = bVarArr;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FastKV.this.writeToCFile();
        }
    }

    /* loaded from: classes5.dex */
    public interface b<T> {
        T a(byte[] bArr, int i11, int i12);

        String a();

        byte[] a(T t11);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class d implements Comparable<d> {

        /* renamed from: a, reason: collision with root package name */
        int f35704a;

        /* renamed from: b, reason: collision with root package name */
        int f35705b;

        d(int i11, int i12) {
            this.f35705b = i11;
            this.f35704a = i12;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f35705b - dVar.f35705b;
        }
    }

    static {
        int a11 = a1.a();
        PAGE_SIZE = a11;
        int max = Math.max(a11 << 1, 16384);
        DOUBLE_LIMIT = max;
        TRUNCATE_THRESHOLD = max << 1;
        TYPE_SIZE = new int[]{0, 1, 4, 4, 8, 8};
    }

    FastKV(String str, String str2, b[] bVarArr, int i11) {
        this.path = str;
        this.name = str2;
        this.writingMode = i11;
        HashMap hashMap = new HashMap();
        x0 x0Var = x0.f35884a;
        hashMap.put(x0Var.a(), x0Var);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String a11 = bVar.a();
                if (hashMap.containsKey(a11)) {
                    error("duplicate encoder tag:" + a11);
                } else {
                    hashMap.put(a11, bVar);
                }
            }
        }
        this.encoderMap = hashMap;
        loadData();
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b11) {
        Object obj2;
        int length;
        int saveArray = saveArray(str, bArr, b11);
        if (saveArray != 0) {
            String str2 = this.tempExternalName;
            boolean z10 = str2 != null;
            if (z10) {
                this.tempExternalName = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            this.data.put(str, b11 == 6 ? new o(this.updateStart, saveArray, (String) obj2, length, z10) : b11 == 7 ? new g(this.updateStart, saveArray, obj2, length, z10) : new n(this.updateStart, saveArray, obj2, length, z10));
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, p pVar, byte b11) {
        if (pVar == null) {
            addObject(str, obj, bArr, b11);
        } else if (pVar.f35835b || pVar.f35838e != bArr.length) {
            updateObject(str, obj, bArr, pVar);
        } else {
            updateBytes(pVar.f35792a, bArr);
            pVar.f35837d = obj;
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i11 = this.dataEnd;
        if (i11 <= 16384) {
            return 4096;
        }
        return i11 <= 65536 ? 8192 : 16384;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
    }

    private void checkIfCommit() {
        if (this.writingMode == 0 || !this.autoCommit) {
            return;
        }
        commitToCFile();
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i11) {
        if (i11 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void checkValueSize(int i11, boolean z10) {
        if (z10) {
            if (i11 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i11 < 0 || i11 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        z zVar = this.fastBuffer;
        if (zVar == null || zVar.f35885a.length != PAGE_SIZE) {
            this.fastBuffer = new z(PAGE_SIZE);
        } else {
            zVar.b(0, 0);
            this.fastBuffer.a(4, 0L);
        }
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i11 = this.writingMode;
        if (i11 == 1) {
            this.executor.execute(new a());
        } else if (i11 == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i11) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e11) {
                error(e11);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i11);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i11, int i12) {
        this.invalidBytes += i12 - i11;
        this.invalids.add(new d(i11, i12));
    }

    private void deleteCFiles() {
        try {
            a1.a(new File(this.path, this.name + C_SUFFIX));
            a1.a(new File(this.path, this.name + TEMP_SUFFIX));
        } catch (Exception e11) {
            error(e11);
        }
    }

    private void ensureSize(int i11) {
        int length = this.fastBuffer.f35885a.length;
        int i12 = this.dataEnd + i11;
        if (i12 >= length) {
            int i13 = this.invalidBytes;
            if (i13 > i11 && i13 > bytesThreshold()) {
                gc(i11);
                return;
            }
            int newCapacity = getNewCapacity(length, i12);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.f35885a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.f35885a = bArr;
            if (this.writingMode == 0) {
                try {
                    FileChannel fileChannel = this.aChannel;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    long j11 = newCapacity;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j11);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j11);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e11) {
                    error(new Exception(MAP_FAILED, e11));
                    this.fastBuffer.b(0, this.dataEnd - 12);
                    this.fastBuffer.a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void error(Exception exc) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.b(this.name, exc);
        }
    }

    private void error(String str) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.b(this.name, new Exception(str));
        }
    }

    private void fastPutString(String str, String str2, o oVar) {
        int b11 = z.b(str2);
        if (oVar == null) {
            int b12 = z.b(str);
            checkKeySize(b12);
            int i11 = b12 + 4;
            this.updateSize = i11 + b11;
            preparePutBytes();
            this.fastBuffer.a((byte) 6);
            putKey(str, b12);
            putStringValue(str2, b11);
            Map<String, h> map = this.data;
            int i12 = this.updateStart;
            map.put(str, new o(i12, i12 + i11, str2, b11, false));
            updateChange();
        } else {
            int i13 = oVar.f35792a;
            int i14 = i13 - oVar.f35836c;
            int i15 = oVar.f35838e;
            boolean z10 = false;
            if (i15 == b11) {
                this.checksum ^= this.fastBuffer.a(i13, i15);
                if (b11 == str2.length()) {
                    str2.getBytes(0, b11, this.fastBuffer.f35885a, oVar.f35792a);
                } else {
                    z zVar = this.fastBuffer;
                    zVar.f35886b = oVar.f35792a;
                    zVar.c(str2);
                }
                this.updateStart = oVar.f35792a;
                this.updateSize = b11;
            } else {
                this.updateSize = i14 + b11;
                preparePutBytes();
                this.fastBuffer.a((byte) 6);
                int i16 = i14 - 3;
                z zVar2 = this.fastBuffer;
                byte[] bArr = zVar2.f35885a;
                System.arraycopy(bArr, oVar.f35836c + 1, bArr, zVar2.f35886b, i16);
                this.fastBuffer.f35886b += i16;
                putStringValue(str2, b11);
                remove((byte) 6, oVar.f35836c, oVar.f35792a + oVar.f35838e);
                r5 = oVar.f35835b ? (String) oVar.f35837d : null;
                oVar.f35835b = false;
                int i17 = this.updateStart;
                oVar.f35836c = i17;
                oVar.f35792a = i17 + i14;
                oVar.f35838e = b11;
                z10 = true;
            }
            oVar.f35837d = str2;
            updateChange();
            if (z10) {
                checkGC();
            }
            if (r5 != null) {
                a1.a(new File(this.path + this.name, r5));
            }
        }
        checkIfCommit();
    }

    private byte[] getArrayFromFile(g gVar) {
        try {
            byte[] c11 = a1.c(new File(this.path + this.name, (String) gVar.f35837d));
            return c11 != null ? c11 : EMPTY_ARRAY;
        } catch (Exception e11) {
            error(e11);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i11, int i12) {
        if (i12 > 536870912) {
            throw new IllegalStateException("data size out of limit");
        }
        int i13 = PAGE_SIZE;
        if (i12 <= i13) {
            return i13;
        }
        while (i11 < i12) {
            int i14 = DOUBLE_LIMIT;
            i11 = i11 <= i14 ? i11 << 1 : i11 + i14;
        }
        return i11;
    }

    private Object getObjectFromFile(n nVar) {
        try {
            byte[] c11 = a1.c(new File(this.path + this.name, (String) nVar.f35837d));
            if (c11 == null) {
                warning(new Exception("Read object data failed"));
                return null;
            }
            int i11 = c11[0] & 255;
            String str = new String(c11, 1, i11, StandardCharsets.UTF_8);
            b bVar = this.encoderMap.get(str);
            if (bVar != null) {
                int i12 = i11 + 1;
                return bVar.a(c11, i12, c11.length - i12);
            }
            warning(new Exception("No encoder for tag:" + str));
            return null;
        } catch (Exception e11) {
            error(e11);
            return null;
        }
    }

    private String getStringFromFile(o oVar) {
        try {
            byte[] c11 = a1.c(new File(this.path + this.name, (String) oVar.f35837d));
            if (c11 != null && c11.length != 0) {
                return new String(c11, StandardCharsets.UTF_8);
            }
            return "";
        } catch (Exception e11) {
            error(e11);
        }
        return "";
    }

    private void info(String str) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        z zVar = new z(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(zVar.f35885a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f35885a;
        byte[] bArr2 = zVar.f35885a;
        for (int i11 = 0; i11 < this.dataEnd; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private synchronized void loadData() {
        try {
            long nanoTime = System.nanoTime();
            if (!loadFromCFile() && this.writingMode == 0) {
                loadFromABFile();
            }
            if (this.fastBuffer == null) {
                this.fastBuffer = new z(PAGE_SIZE);
            }
            if (this.logger != null) {
                info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void loadFromABFile() {
        FastKV fastKV = this;
        File file = new File(fastKV.path, fastKV.name + A_SUFFIX);
        File file2 = new File(fastKV.path, fastKV.name + B_SUFFIX);
        try {
            if (a1.d(file) && a1.d(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                fastKV.aChannel = randomAccessFile.getChannel();
                fastKV.bChannel = randomAccessFile2.getChannel();
                try {
                    FileChannel fileChannel = fastKV.aChannel;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, length > 0 ? length : PAGE_SIZE);
                    fastKV.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = fastKV.bChannel.map(mapMode, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    fastKV.bBuffer = map2;
                    map2.order(byteOrder);
                    fastKV.fastBuffer = new z(fastKV.aBuffer.capacity());
                    if (length == 0 && length2 == 0) {
                        fastKV.dataEnd = 12;
                        return;
                    }
                    int i11 = fastKV.aBuffer.getInt();
                    long j11 = fastKV.aBuffer.getLong();
                    int i12 = fastKV.bBuffer.getInt();
                    long j12 = fastKV.bBuffer.getLong();
                    if (i11 >= 0) {
                        if (i11 <= length - 12) {
                            fastKV = this;
                            fastKV.dataEnd = i11 + 12;
                            fastKV.aBuffer.rewind();
                            fastKV.aBuffer.get(fastKV.fastBuffer.f35885a, 0, fastKV.dataEnd);
                            if (j11 == fastKV.fastBuffer.a(12, i11) && parseData() == 0) {
                                fastKV.checksum = j11;
                                if (length == length2 && isABFileEqual()) {
                                    return;
                                }
                                fastKV.warning(new Exception("B file error"));
                                fastKV.copyBuffer(fastKV.aBuffer, fastKV.bBuffer, fastKV.dataEnd);
                                return;
                            }
                        } else {
                            fastKV = this;
                        }
                    }
                    if (i12 >= 0 && i12 <= length2 - 12) {
                        fastKV.data.clear();
                        clearInvalid();
                        fastKV.dataEnd = i12 + 12;
                        if (fastKV.fastBuffer.f35885a.length != fastKV.bBuffer.capacity()) {
                            fastKV.fastBuffer = new z(fastKV.bBuffer.capacity());
                        }
                        fastKV.bBuffer.rewind();
                        fastKV.bBuffer.get(fastKV.fastBuffer.f35885a, 0, fastKV.dataEnd);
                        if (j12 == fastKV.fastBuffer.a(12, i12) && parseData() == 0) {
                            fastKV.warning(new Exception("A file error"));
                            fastKV.copyBuffer(fastKV.bBuffer, fastKV.aBuffer, fastKV.dataEnd);
                            fastKV.checksum = j12;
                            return;
                        }
                    }
                    fastKV.error(BOTH_FILES_ERROR);
                    resetData();
                    return;
                } catch (IOException e11) {
                    fastKV.error(e11);
                    toBlockingMode();
                    fastKV.tryBlockingIO(file, file2);
                    return;
                }
            }
            fastKV.error(new Exception(OPEN_FILE_FAILED));
            toBlockingMode();
        } catch (Exception e12) {
            fastKV.error(e12);
            clearData();
            toBlockingMode();
        }
    }

    private boolean loadFromCFile() {
        File file = new File(this.path, this.name + C_SUFFIX);
        File file2 = new File(this.path, this.name + TEMP_SUFFIX);
        boolean z10 = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!loadWithBlockingIO(file)) {
                    clearData();
                    deleteCFiles();
                    return false;
                }
                if (this.writingMode != 0) {
                    return false;
                }
                if (!writeToABFile(this.fastBuffer)) {
                    this.writingMode = 1;
                    return false;
                }
                info("recover from c file");
                try {
                    deleteCFiles();
                    return true;
                } catch (Exception e11) {
                    e = e11;
                    z10 = true;
                    error(e);
                    return z10;
                }
            }
            if (this.writingMode == 0) {
                return false;
            }
            File file3 = new File(this.path, this.name + A_SUFFIX);
            File file4 = new File(this.path, this.name + B_SUFFIX);
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            tryBlockingIO(file3, file4);
            return false;
        } catch (Exception e12) {
            e = e12;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i11 = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i11);
            z zVar = this.fastBuffer;
            if (zVar == null || zVar.f35885a.length != newCapacity) {
                zVar = new z(new byte[newCapacity]);
                this.fastBuffer = zVar;
            } else {
                zVar.f35886b = 0;
            }
            a1.a(file, zVar.f35885a, i11);
            int d11 = zVar.d();
            long e11 = zVar.e();
            this.dataEnd = d11 + 12;
            if (d11 >= 0 && d11 <= i11 - 12 && e11 == zVar.a(12, d11) && parseData() == 0) {
                this.checksum = e11;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        d dVar = this.invalids.get(size);
        while (size > 0) {
            int i11 = size - 1;
            d dVar2 = this.invalids.get(i11);
            if (dVar.f35705b == dVar2.f35704a) {
                dVar2.f35704a = dVar.f35704a;
                this.invalids.remove(size);
            }
            dVar = dVar2;
            size = i11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x016d, code lost:
    
        throw new java.lang.Exception(com.mbridge.msdk.foundation.tools.FastKV.PARSE_DATA_FAILED);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseData() {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.parseData():int");
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i11 = this.dataEnd;
        this.updateStart = i11;
        this.dataEnd = this.updateSize + i11;
        this.fastBuffer.f35886b = i11;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i11) {
        this.fastBuffer.a((byte) i11);
        if (i11 != str.length()) {
            this.fastBuffer.c(str);
            return;
        }
        z zVar = this.fastBuffer;
        str.getBytes(0, i11, zVar.f35885a, zVar.f35886b);
        this.fastBuffer.f35886b += i11;
    }

    private void putStringValue(String str, int i11) {
        this.fastBuffer.a((short) i11);
        if (i11 != str.length()) {
            this.fastBuffer.c(str);
        } else {
            z zVar = this.fastBuffer;
            str.getBytes(0, i11, zVar.f35885a, zVar.f35886b);
        }
    }

    private void remove(byte b11, int i11, int i12) {
        countInvalid(i11, i12);
        byte[] bArr = this.fastBuffer.f35885a;
        this.checksum = (((bArr[i11] ^ r9) & 255) << ((i11 & 7) << 3)) ^ this.checksum;
        bArr[i11] = (byte) (b11 | Byte.MIN_VALUE);
        this.removeStart = i11;
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int capacity = mappedByteBuffer.capacity();
        int i11 = PAGE_SIZE;
        if (capacity != i11) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            long j11 = i11;
            fileChannel.truncate(j11);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, j11);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        a1.a(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b11) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b11);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String b12 = a1.b();
        if (!a1.a(new File(this.path + this.name, b12), bArr)) {
            error("save large value failed");
            return 0;
        }
        this.tempExternalName = b12;
        byte[] bArr2 = new byte[32];
        b12.getBytes(0, 32, bArr2, 0);
        return wrapArray(str, bArr2, (byte) (b11 | 64));
    }

    private long shiftCheckSum(long j11, int i11) {
        int i12 = (i11 & 7) << 3;
        return (j11 >>> (64 - i12)) | (j11 << i12);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i11 = this.removeStart;
        if (i11 != 0) {
            mappedByteBuffer.put(i11, this.fastBuffer.f35885a[i11]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f35885a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        a1.a(this.aChannel);
        a1.a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i11) {
        int i12 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i12, i11 + i12);
        byte[] bArr = this.fastBuffer.f35885a;
        if (newCapacity >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[newCapacity];
        System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
        this.fastBuffer.f35885a = bArr2;
        if (this.writingMode == 0) {
            try {
                long j11 = newCapacity;
                this.aChannel.truncate(j11);
                FileChannel fileChannel = this.aChannel;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j11);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bChannel.truncate(j11);
                MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j11);
                this.bBuffer = map2;
                map2.order(byteOrder);
            } catch (IOException e11) {
                error(new Exception(MAP_FAILED, e11));
                toBlockingMode();
            }
        }
        info(TRUNCATE_FINISH);
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e11) {
            warning(e11);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e12) {
            warning(e12);
        }
        clearData();
    }

    private void updateBoolean(byte b11, int i11) {
        long shiftCheckSum = this.checksum ^ shiftCheckSum(1L, i11);
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.put(i11, b11);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i11, b11);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.f35885a[i11] = b11;
    }

    private void updateBytes(int i11, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.a(i11, length);
        z zVar = this.fastBuffer;
        zVar.f35886b = i11;
        zVar.a(bArr);
        long a11 = this.checksum ^ this.fastBuffer.a(i11, length);
        this.checksum = a11;
        if (this.writingMode != 0) {
            this.fastBuffer.a(4, a11);
            return;
        }
        this.aBuffer.putInt(0, -1);
        this.aBuffer.putLong(4, this.checksum);
        this.aBuffer.position(i11);
        this.aBuffer.put(bArr);
        this.aBuffer.putInt(0, this.dataEnd - 12);
        this.bBuffer.putLong(4, this.checksum);
        this.bBuffer.position(i11);
        this.bBuffer.put(bArr);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.a(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.b(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i11, long j11, int i12) {
        long shiftCheckSum = shiftCheckSum(j11, i12) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putInt(i12, i11);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i12, i11);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.b(i12, i11);
    }

    private void updateInt64(long j11, long j12, int i11) {
        long shiftCheckSum = shiftCheckSum(j12, i11) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putLong(i11, j11);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i11, j11);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a(i11, j11);
    }

    private void updateObject(String str, Object obj, byte[] bArr, p pVar) {
        int saveArray = saveArray(str, bArr, pVar.a());
        if (saveArray != 0) {
            String str2 = pVar.f35835b ? (String) pVar.f35837d : null;
            remove(pVar.a(), pVar.f35836c, pVar.f35792a + pVar.f35838e);
            String str3 = this.tempExternalName;
            boolean z10 = str3 != null;
            pVar.f35836c = this.updateStart;
            pVar.f35792a = saveArray;
            pVar.f35835b = z10;
            if (z10) {
                pVar.f35837d = str3;
                pVar.f35838e = 32;
                this.tempExternalName = null;
            } else {
                pVar.f35837d = obj;
                pVar.f35838e = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                a1.a(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i11, int[] iArr) {
        for (h hVar : this.data.values()) {
            int i12 = hVar.f35792a;
            if (i12 > i11) {
                int i13 = iArr[(a1.a(iArr, i12) << 1) + 1];
                hVar.f35792a -= i13;
                if (hVar.a() >= 6) {
                    ((p) hVar).f35836c -= i13;
                }
            }
        }
    }

    private void warning(Exception exc) {
        c cVar = this.logger;
        if (cVar != null) {
            cVar.a(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b11) {
        wrapHeader(str, b11, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        z zVar = this.fastBuffer;
        int i11 = zVar.f35886b;
        zVar.a(bArr);
        return i11;
    }

    private void wrapHeader(String str, byte b11) {
        wrapHeader(str, b11, TYPE_SIZE[b11]);
    }

    private void wrapHeader(String str, byte b11, int i11) {
        int b12 = z.b(str);
        checkKeySize(b12);
        this.updateSize = b12 + 2 + i11;
        preparePutBytes();
        this.fastBuffer.a(b11);
        putKey(str, b12);
    }

    private boolean writeToABFile(z zVar) {
        int length = zVar.f35885a.length;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (!a1.d(file) || !a1.d(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j11 = length;
            randomAccessFile.setLength(j11);
            randomAccessFile2.setLength(j11);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            FileChannel fileChannel = this.aChannel;
            FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
            MappedByteBuffer map = fileChannel.map(mapMode, 0L, j11);
            this.aBuffer = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j11);
            this.bBuffer = map2;
            map2.order(byteOrder);
            this.aBuffer.put(zVar.f35885a, 0, this.dataEnd);
            this.bBuffer.put(zVar.f35885a, 0, this.dataEnd);
            return true;
        } catch (Exception e11) {
            error(e11);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            try {
                File file = new File(this.path, this.name + TEMP_SUFFIX);
                if (a1.d(file)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(this.dataEnd);
                    randomAccessFile.write(this.fastBuffer.f35885a, 0, this.dataEnd);
                    randomAccessFile.close();
                    File file2 = new File(this.path, this.name + C_SUFFIX);
                    if (file2.exists()) {
                        if (file2.delete()) {
                        }
                    }
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    warning(new Exception("rename failed"));
                }
            } catch (Exception e11) {
                error(e11);
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    void gc(int i11) {
        Collections.sort(this.invalids);
        mergeInvalids();
        d dVar = this.invalids.get(0);
        int i12 = dVar.f35705b;
        int i13 = this.dataEnd;
        int i14 = i13 - this.invalidBytes;
        int i15 = i14 - 12;
        int i16 = i14 - i12;
        int i17 = i13 - i12;
        boolean z10 = i15 < i17 + i16;
        if (!z10) {
            this.checksum ^= this.fastBuffer.a(i12, i17);
        }
        int size = this.invalids.size();
        int i18 = size - 1;
        int i19 = this.dataEnd - this.invalids.get(i18).f35704a;
        int[] iArr = new int[(i19 > 0 ? size : i18) << 1];
        int i20 = dVar.f35705b;
        int i21 = dVar.f35704a;
        for (int i22 = 1; i22 < size; i22++) {
            d dVar2 = this.invalids.get(i22);
            int i23 = dVar2.f35705b - i21;
            byte[] bArr = this.fastBuffer.f35885a;
            System.arraycopy(bArr, i21, bArr, i20, i23);
            int i24 = (i22 - 1) << 1;
            iArr[i24] = i21;
            iArr[i24 + 1] = i21 - i20;
            i20 += i23;
            i21 = dVar2.f35704a;
        }
        if (i19 > 0) {
            byte[] bArr2 = this.fastBuffer.f35885a;
            System.arraycopy(bArr2, i21, bArr2, i20, i19);
            int i25 = i18 << 1;
            iArr[i25] = i21;
            iArr[i25 + 1] = i21 - i20;
        }
        clearInvalid();
        if (z10) {
            this.checksum = this.fastBuffer.a(12, i15);
        } else {
            this.checksum ^= this.fastBuffer.a(i12, i16);
        }
        this.dataEnd = i14;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i12);
            this.aBuffer.put(this.fastBuffer.f35885a, i12, i16);
            this.aBuffer.putInt(0, i15);
            this.bBuffer.putInt(0, i15);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i12);
            this.bBuffer.put(this.fastBuffer.f35885a, i12, i16);
        } else {
            this.fastBuffer.b(0, i15);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i12, iArr);
        int i26 = i14 + i11;
        if (this.fastBuffer.f35885a.length - i26 > TRUNCATE_THRESHOLD) {
            truncate(i26);
        }
        info(GC_FINISH);
    }

    public synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, h> entry : this.data.entrySet()) {
            String key = entry.getKey();
            h value = entry.getValue();
            switch (value.a()) {
                case 1:
                    valueOf = Boolean.valueOf(((i) value).f35795b);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((l) value).f35822b);
                    break;
                case 3:
                    valueOf = Float.valueOf(((k) value).f35801b);
                    break;
                case 4:
                    valueOf = Long.valueOf(((m) value).f35826b);
                    break;
                case 5:
                    valueOf = Double.valueOf(((j) value).f35800b);
                    break;
                case 6:
                    o oVar = (o) value;
                    if (oVar.f35835b) {
                        valueOf = getStringFromFile(oVar);
                        break;
                    } else {
                        valueOf = oVar.f35837d;
                        break;
                    }
                case 7:
                    g gVar = (g) value;
                    if (gVar.f35835b) {
                        valueOf = getArrayFromFile(gVar);
                        break;
                    } else {
                        valueOf = gVar.f35837d;
                        break;
                    }
                case 8:
                    n nVar = (n) value;
                    if (nVar.f35835b) {
                        valueOf = getObjectFromFile(nVar);
                        break;
                    } else {
                        valueOf = nVar.f35837d;
                        break;
                    }
                default:
                    valueOf = null;
                    break;
            }
            hashMap.put(key, valueOf);
        }
        return hashMap;
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        try {
            g gVar = (g) this.data.get(str);
            if (gVar != null) {
                return gVar.f35835b ? getArrayFromFile(gVar) : (byte[]) gVar.f35837d;
            }
            return bArr;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public synchronized boolean getBoolean(String str, boolean z10) {
        i iVar = (i) this.data.get(str);
        if (iVar != null) {
            z10 = iVar.f35795b;
        }
        return z10;
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public synchronized double getDouble(String str, double d11) {
        j jVar = (j) this.data.get(str);
        if (jVar != null) {
            d11 = jVar.f35800b;
        }
        return d11;
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public synchronized float getFloat(String str, float f11) {
        k kVar = (k) this.data.get(str);
        if (kVar != null) {
            f11 = kVar.f35801b;
        }
        return f11;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized int getInt(String str, int i11) {
        l lVar = (l) this.data.get(str);
        if (lVar != null) {
            i11 = lVar.f35822b;
        }
        return i11;
    }

    public synchronized long getLong(String str) {
        m mVar;
        mVar = (m) this.data.get(str);
        return mVar == null ? 0L : mVar.f35826b;
    }

    public synchronized long getLong(String str, long j11) {
        m mVar = (m) this.data.get(str);
        if (mVar != null) {
            j11 = mVar.f35826b;
        }
        return j11;
    }

    public synchronized <T> T getObject(String str) {
        try {
            n nVar = (n) this.data.get(str);
            if (nVar != null) {
                return nVar.f35835b ? (T) getObjectFromFile(nVar) : (T) nVar.f35837d;
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public synchronized String getString(String str, String str2) {
        try {
            o oVar = (o) this.data.get(str);
            if (oVar != null) {
                return oVar.f35835b ? getStringFromFile(oVar) : (String) oVar.f35837d;
            }
            return str2;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, null);
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, b> map2) {
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && !key.isEmpty()) {
                    if (value instanceof String) {
                        putString(key, (String) value);
                    } else if (value instanceof Boolean) {
                        putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        putDouble(key, ((Double) value).doubleValue());
                    } else if (value instanceof Set) {
                        Set<String> set = (Set) value;
                        if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                            putStringSet(key, set);
                        }
                    } else if (value instanceof byte[]) {
                        putArray(key, (byte[]) value);
                    } else if (map2 != null) {
                        b bVar = map2.get(value.getClass());
                        if (bVar != null) {
                            putObject(key, value, bVar);
                        } else {
                            warning(new Exception("missing encoder for type:" + value.getClass()));
                        }
                    } else {
                        warning(new Exception("missing encoders"));
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putArray(String str, byte[] bArr) {
        try {
            checkKey(str);
            if (bArr == null) {
                remove(str);
            } else {
                addOrUpdate(str, bArr, bArr, (g) this.data.get(str), (byte) 7);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putBoolean(String str, boolean z10) {
        try {
            checkKey(str);
            i iVar = (i) this.data.get(str);
            if (iVar == null) {
                wrapHeader(str, (byte) 1);
                z zVar = this.fastBuffer;
                int i11 = zVar.f35886b;
                zVar.a(z10 ? (byte) 1 : (byte) 0);
                updateChange();
                this.data.put(str, new i(i11, z10));
                checkIfCommit();
            } else if (iVar.f35795b != z10) {
                iVar.f35795b = z10;
                updateBoolean(z10 ? (byte) 1 : (byte) 0, iVar.f35792a);
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putDouble(String str, double d11) {
        try {
            checkKey(str);
            j jVar = (j) this.data.get(str);
            if (jVar == null) {
                wrapHeader(str, (byte) 5);
                z zVar = this.fastBuffer;
                int i11 = zVar.f35886b;
                zVar.a(Double.doubleToRawLongBits(d11));
                updateChange();
                this.data.put(str, new j(i11, d11));
                checkIfCommit();
            } else if (jVar.f35800b != d11) {
                long doubleToRawLongBits = Double.doubleToRawLongBits(d11);
                long doubleToRawLongBits2 = Double.doubleToRawLongBits(jVar.f35800b) ^ doubleToRawLongBits;
                jVar.f35800b = d11;
                updateInt64(doubleToRawLongBits, doubleToRawLongBits2, jVar.f35792a);
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putFloat(String str, float f11) {
        try {
            checkKey(str);
            k kVar = (k) this.data.get(str);
            if (kVar == null) {
                wrapHeader(str, (byte) 3);
                z zVar = this.fastBuffer;
                int i11 = zVar.f35886b;
                zVar.g(Float.floatToRawIntBits(f11));
                updateChange();
                this.data.put(str, new k(i11, f11));
                checkIfCommit();
            } else if (kVar.f35801b != f11) {
                kVar.f35801b = f11;
                updateInt32(Float.floatToRawIntBits(f11), (Float.floatToRawIntBits(kVar.f35801b) ^ r6) & 4294967295L, kVar.f35792a);
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putInt(String str, int i11) {
        try {
            checkKey(str);
            l lVar = (l) this.data.get(str);
            if (lVar == null) {
                wrapHeader(str, (byte) 2);
                z zVar = this.fastBuffer;
                int i12 = zVar.f35886b;
                zVar.g(i11);
                updateChange();
                this.data.put(str, new l(i12, i11));
                checkIfCommit();
            } else {
                if (lVar.f35822b != i11) {
                    lVar.f35822b = i11;
                    updateInt32(i11, (r6 ^ i11) & 4294967295L, lVar.f35792a);
                    checkIfCommit();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putLong(String str, long j11) {
        try {
            checkKey(str);
            m mVar = (m) this.data.get(str);
            if (mVar == null) {
                wrapHeader(str, (byte) 4);
                z zVar = this.fastBuffer;
                int i11 = zVar.f35886b;
                zVar.a(j11);
                updateChange();
                this.data.put(str, new m(i11, j11));
                checkIfCommit();
            } else {
                long j12 = mVar.f35826b;
                if (j12 != j11) {
                    mVar.f35826b = j11;
                    updateInt64(j11, j11 ^ j12, mVar.f35792a);
                    checkIfCommit();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized <T> void putObject(String str, T t11, b<T> bVar) {
        byte[] bArr;
        checkKey(str);
        if (bVar == null) {
            throw new IllegalArgumentException("Encoder is null");
        }
        String a11 = bVar.a();
        if (a11 == null || a11.isEmpty() || a11.length() > 50) {
            throw new IllegalArgumentException("Invalid encoder tag:" + a11);
        }
        if (!this.encoderMap.containsKey(a11)) {
            throw new IllegalArgumentException("Encoder hasn't been registered");
        }
        if (t11 == null) {
            remove(str);
            return;
        }
        try {
            bArr = bVar.a(t11);
        } catch (Exception e11) {
            error(e11);
            bArr = null;
        }
        if (bArr == null) {
            remove(str);
            return;
        }
        int b11 = z.b(a11);
        z zVar = new z(b11 + 1 + bArr.length);
        zVar.a((byte) b11);
        zVar.c(a11);
        zVar.a(bArr);
        addOrUpdate(str, t11, zVar.f35885a, (n) this.data.get(str), (byte) 8);
    }

    public synchronized void putString(String str, String str2) {
        try {
            checkKey(str);
            if (str2 == null) {
                remove(str);
            } else {
                o oVar = (o) this.data.get(str);
                if (str2.length() * 3 < 2048) {
                    fastPutString(str, str2, oVar);
                } else {
                    addOrUpdate(str, str2, str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8), oVar, (byte) 6);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                putObject(str, set, x0.f35884a);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void remove(String str) {
        try {
            h hVar = this.data.get(str);
            if (hVar != null) {
                this.data.remove(str);
                byte a11 = hVar.a();
                String str2 = null;
                if (a11 <= 5) {
                    int b11 = z.b(str);
                    int i11 = hVar.f35792a;
                    remove(a11, i11 - (b11 + 2), i11 + TYPE_SIZE[a11]);
                } else {
                    p pVar = (p) hVar;
                    remove(a11, pVar.f35836c, pVar.f35792a + pVar.f35838e);
                    if (pVar.f35835b) {
                        str2 = (String) pVar.f35837d;
                    }
                }
                byte b12 = (byte) (a11 | Byte.MIN_VALUE);
                if (this.writingMode == 0) {
                    this.aBuffer.putLong(4, this.checksum);
                    this.aBuffer.put(this.removeStart, b12);
                    this.bBuffer.putLong(4, this.checksum);
                    this.bBuffer.put(this.removeStart, b12);
                } else {
                    this.fastBuffer.a(4, this.checksum);
                }
                this.removeStart = 0;
                if (str2 != null) {
                    a1.a(new File(this.path + this.name, str2));
                }
                checkGC();
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }
}
