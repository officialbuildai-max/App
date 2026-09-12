package org.apache.tools.zip;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public class ZipFile {
    private static final int BYTE_SHIFT = 8;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MIN_EOCD_SIZE = 22;
    private static final int NIBLET_MASK = 15;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int SHORT = 2;
    private static final int WORD = 4;
    private RandomAccessFile archive;
    private String encoding;
    private Hashtable entries;
    private Hashtable nameMap;

    /* loaded from: classes7.dex */
    private class BoundedInputStream extends InputStream {
        private boolean addDummyByte = false;
        private long loc;
        private long remaining;

        BoundedInputStream(long j11, long j12) {
            this.remaining = j12;
            this.loc = j11;
        }

        void addDummy() {
            this.addDummyByte = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read;
            long j11 = this.remaining;
            this.remaining = j11 - 1;
            if (j11 <= 0) {
                if (!this.addDummyByte) {
                    return -1;
                }
                this.addDummyByte = false;
                return 0;
            }
            synchronized (ZipFile.this.archive) {
                RandomAccessFile randomAccessFile = ZipFile.this.archive;
                long j12 = this.loc;
                this.loc = 1 + j12;
                randomAccessFile.seek(j12);
                read = ZipFile.this.archive.read();
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            int read;
            long j11 = this.remaining;
            if (j11 <= 0) {
                if (!this.addDummyByte) {
                    return -1;
                }
                this.addDummyByte = false;
                bArr[i11] = 0;
                return 1;
            }
            if (i12 <= 0) {
                return 0;
            }
            if (i12 > j11) {
                i12 = (int) j11;
            }
            synchronized (ZipFile.this.archive) {
                ZipFile.this.archive.seek(this.loc);
                read = ZipFile.this.archive.read(bArr, i11, i12);
            }
            if (read > 0) {
                long j12 = read;
                this.loc += j12;
                this.remaining -= j12;
            }
            return read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class OffsetEntry {
        private long dataOffset;
        private long headerOffset;

        private OffsetEntry() {
            this.headerOffset = -1L;
            this.dataOffset = -1L;
        }
    }

    public ZipFile(File file) throws IOException {
        this(file, (String) null);
    }

    public ZipFile(File file, String str) throws IOException {
        this.entries = new Hashtable(509);
        this.nameMap = new Hashtable(509);
        this.encoding = str;
        this.archive = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
        try {
            populateFromCentralDirectory();
            resolveLocalFileHeaderData();
        } catch (IOException e11) {
            try {
                this.archive.close();
            } catch (IOException unused) {
            }
            throw e11;
        }
    }

    public ZipFile(String str) throws IOException {
        this(new File(str), (String) null);
    }

    public ZipFile(String str, String str2) throws IOException {
        this(new File(str), str2);
    }

    public static void closeQuietly(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private static long dosToJavaTime(long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j11 >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j11 >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j11 >> 16)) & 31);
        calendar.set(11, ((int) (j11 >> 11)) & 31);
        calendar.set(12, ((int) (j11 >> 5)) & 63);
        calendar.set(13, ((int) (j11 << 1)) & 62);
        return calendar.getTime().getTime();
    }

    protected static Date fromDosTime(ZipLong zipLong) {
        return new Date(dosToJavaTime(zipLong.getValue()));
    }

    private void populateFromCentralDirectory() throws IOException {
        positionAtCentralDirectory();
        byte[] bArr = new byte[42];
        byte[] bArr2 = new byte[4];
        this.archive.readFully(bArr2);
        long value = ZipLong.getValue(ZipOutputStream.CFH_SIG);
        for (long value2 = ZipLong.getValue(bArr2); value2 == value; value2 = ZipLong.getValue(bArr2)) {
            this.archive.readFully(bArr);
            ZipEntry zipEntry = new ZipEntry();
            zipEntry.setPlatform((ZipShort.getValue(bArr, 0) >> 8) & 15);
            zipEntry.setMethod(ZipShort.getValue(bArr, 6));
            zipEntry.setTime(dosToJavaTime(ZipLong.getValue(bArr, 8)));
            zipEntry.setCrc(ZipLong.getValue(bArr, 12));
            zipEntry.setCompressedSize(ZipLong.getValue(bArr, 16));
            zipEntry.setSize(ZipLong.getValue(bArr, 20));
            int value3 = ZipShort.getValue(bArr, 24);
            int value4 = ZipShort.getValue(bArr, 26);
            int value5 = ZipShort.getValue(bArr, 28);
            zipEntry.setInternalAttributes(ZipShort.getValue(bArr, 32));
            zipEntry.setExternalAttributes(ZipLong.getValue(bArr, 34));
            byte[] bArr3 = new byte[value3];
            this.archive.readFully(bArr3);
            zipEntry.setName(getString(bArr3));
            OffsetEntry offsetEntry = new OffsetEntry();
            offsetEntry.headerOffset = ZipLong.getValue(bArr, 38);
            this.entries.put(zipEntry, offsetEntry);
            this.nameMap.put(zipEntry.getName(), zipEntry);
            this.archive.skipBytes(value4);
            byte[] bArr4 = new byte[value5];
            this.archive.readFully(bArr4);
            zipEntry.setComment(getString(bArr4));
            this.archive.readFully(bArr2);
        }
    }

    private void positionAtCentralDirectory() throws IOException {
        long length = this.archive.length() - 22;
        boolean z10 = false;
        if (length >= 0) {
            this.archive.seek(length);
            byte[] bArr = ZipOutputStream.EOCD_SIG;
            int read = this.archive.read();
            while (true) {
                if (read != -1) {
                    if (read == bArr[0] && this.archive.read() == bArr[1] && this.archive.read() == bArr[2] && this.archive.read() == bArr[3]) {
                        z10 = true;
                        break;
                    } else {
                        length--;
                        this.archive.seek(length);
                        read = this.archive.read();
                    }
                } else {
                    break;
                }
            }
        }
        if (!z10) {
            throw new ZipException("archive is not a ZIP archive");
        }
        this.archive.seek(length + 16);
        byte[] bArr2 = new byte[4];
        this.archive.readFully(bArr2);
        this.archive.seek(ZipLong.getValue(bArr2));
    }

    private void resolveLocalFileHeaderData() throws IOException {
        Enumeration entries = getEntries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            OffsetEntry offsetEntry = (OffsetEntry) this.entries.get(zipEntry);
            long j11 = offsetEntry.headerOffset;
            this.archive.seek(LFH_OFFSET_FOR_FILENAME_LENGTH + j11);
            byte[] bArr = new byte[2];
            this.archive.readFully(bArr);
            int value = ZipShort.getValue(bArr);
            this.archive.readFully(bArr);
            int value2 = ZipShort.getValue(bArr);
            this.archive.skipBytes(value);
            byte[] bArr2 = new byte[value2];
            this.archive.readFully(bArr2);
            zipEntry.setExtra(bArr2);
            offsetEntry.dataOffset = j11 + 30 + value + value2;
        }
    }

    public void close() throws IOException {
        this.archive.close();
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Enumeration getEntries() {
        return this.entries.keys();
    }

    public ZipEntry getEntry(String str) {
        return (ZipEntry) this.nameMap.get(str);
    }

    public InputStream getInputStream(ZipEntry zipEntry) throws IOException, ZipException {
        OffsetEntry offsetEntry = (OffsetEntry) this.entries.get(zipEntry);
        if (offsetEntry == null) {
            return null;
        }
        BoundedInputStream boundedInputStream = new BoundedInputStream(offsetEntry.dataOffset, zipEntry.getCompressedSize());
        int method = zipEntry.getMethod();
        if (method == 0) {
            return boundedInputStream;
        }
        if (method == 8) {
            boundedInputStream.addDummy();
            return new InflaterInputStream(boundedInputStream, new Inflater(true));
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Found unsupported compression method ");
        stringBuffer.append(zipEntry.getMethod());
        throw new ZipException(stringBuffer.toString());
    }

    protected String getString(byte[] bArr) throws ZipException {
        String str = this.encoding;
        if (str == null) {
            return new String(bArr);
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e11) {
            throw new ZipException(e11.getMessage());
        }
    }
}
