package com.google.protobuf;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class y {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final com.google.protobuf.i EMPTY_CODED_INPUT_STREAM;
    static final Charset US_ASCII = Charset.forName(C.ASCII_NAME);
    static final Charset UTF_8 = Charset.forName("UTF-8");
    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* loaded from: classes4.dex */
    public interface a extends j {
        void addBoolean(boolean z10);

        boolean getBoolean(int i11);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        a mutableCopyWithCapacity(int i11);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i11);

        boolean setBoolean(int i11, boolean z10);
    }

    /* loaded from: classes4.dex */
    public interface b extends j {
        void addDouble(double d11);

        double getDouble(int i11);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        b mutableCopyWithCapacity(int i11);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i11);

        double setDouble(int i11, double d11);
    }

    /* loaded from: classes4.dex */
    public interface c {
        int getNumber();
    }

    /* loaded from: classes4.dex */
    public interface d {
        c findValueByNumber(int i11);
    }

    /* loaded from: classes4.dex */
    public interface e {
        boolean isInRange(int i11);
    }

    /* loaded from: classes4.dex */
    public interface f extends j {
        void addFloat(float f11);

        float getFloat(int i11);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        f mutableCopyWithCapacity(int i11);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i11);

        float setFloat(int i11, float f11);
    }

    /* loaded from: classes4.dex */
    public interface g extends j {
        void addInt(int i11);

        int getInt(int i11);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        g mutableCopyWithCapacity(int i11);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i11);

        int setInt(int i11, int i12);
    }

    /* loaded from: classes4.dex */
    public static class h extends AbstractList {
        private final a converter;
        private final List<Object> fromList;

        /* loaded from: classes4.dex */
        public interface a {
            Object convert(Object obj);
        }

        public h(List<Object> list, a aVar) {
            this.fromList = list;
            this.converter = aVar;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i11) {
            return this.converter.convert(this.fromList.get(i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* loaded from: classes4.dex */
    public interface i extends j {
        void addLong(long j11);

        long getLong(int i11);

        @Override // com.google.protobuf.y.j
        /* synthetic */ boolean isModifiable();

        @Override // com.google.protobuf.y.j
        /* synthetic */ void makeImmutable();

        @Override // com.google.protobuf.y.j
        i mutableCopyWithCapacity(int i11);

        @Override // com.google.protobuf.y.j
        /* bridge */ /* synthetic */ j mutableCopyWithCapacity(int i11);

        long setLong(int i11, long j11);
    }

    /* loaded from: classes4.dex */
    public interface j extends List, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        j mutableCopyWithCapacity(int i11);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = com.google.protobuf.i.newInstance(bArr);
    }

    private y() {
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(ISO_8859_1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t11) {
        t11.getClass();
        return t11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!Arrays.equals(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        e0.clear(duplicate);
        ByteBuffer duplicate2 = byteBuffer2.duplicate();
        e0.clear(duplicate2);
        return duplicate.equals(duplicate2);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!equalsByteBuffer(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static <T extends s0> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", null);
            return (T) method.invoke(method, null);
        } catch (Exception e11) {
            throw new RuntimeException("Failed to get default instance for " + cls, e11);
        }
    }

    public static int hashBoolean(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            i11 = (i11 * 31) + hashCode(it.next());
        }
        return i11;
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    static int hashCode(byte[] bArr, int i11, int i12) {
        int partialHash = partialHash(i12, bArr, i11, i12);
        if (partialHash == 0) {
            return 1;
        }
        return partialHash;
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int partialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (partialHash == 0) {
                return 1;
            }
            return partialHash;
        }
        int capacity = byteBuffer.capacity() <= 4096 ? byteBuffer.capacity() : 4096;
        byte[] bArr = new byte[capacity];
        ByteBuffer duplicate = byteBuffer.duplicate();
        e0.clear(duplicate);
        int capacity2 = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= capacity ? duplicate.remaining() : capacity;
            duplicate.get(bArr, 0, remaining);
            capacity2 = partialHash(capacity2, bArr, 0, remaining);
        }
        if (capacity2 == 0) {
            return 1;
        }
        return capacity2;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            i11 = (i11 * 31) + hashCodeByteBuffer(it.next());
        }
        return i11;
    }

    public static int hashEnum(c cVar) {
        return cVar.getNumber();
    }

    public static int hashEnumList(List<? extends c> list) {
        Iterator<? extends c> it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            i11 = (i11 * 31) + hashEnum(it.next());
        }
        return i11;
    }

    public static int hashLong(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object mergeMessage(Object obj, Object obj2) {
        return ((s0) obj).toBuilder().mergeFrom((s0) obj2).buildPartial();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialHash(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }
}
