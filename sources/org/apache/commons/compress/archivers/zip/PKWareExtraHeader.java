package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Settings;

/* loaded from: classes7.dex */
public abstract class PKWareExtraHeader implements t {

    /* renamed from: a, reason: collision with root package name */
    private final ZipShort f71243a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f71244b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f71245c;

    /* loaded from: classes7.dex */
    public enum EncryptionAlgorithm {
        DES(26113),
        RC2pre52(26114),
        TripleDES168(26115),
        TripleDES192(26121),
        AES128(26126),
        AES192(26127),
        AES256(26128),
        RC2(26370),
        RC4(26625),
        UNKNOWN(Settings.DEFAULT_INITIAL_WINDOW_SIZE);

        private static final Map<Integer, EncryptionAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap hashMap = new HashMap();
            for (EncryptionAlgorithm encryptionAlgorithm : values()) {
                hashMap.put(Integer.valueOf(encryptionAlgorithm.getCode()), encryptionAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        EncryptionAlgorithm(int i11) {
            this.code = i11;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int i11) {
            return codeToEnum.get(Integer.valueOf(i11));
        }

        public int getCode() {
            return this.code;
        }
    }

    /* loaded from: classes7.dex */
    public enum HashAlgorithm {
        NONE(0),
        CRC32(1),
        MD5(32771),
        SHA1(32772),
        RIPEND160(32775),
        SHA256(32780),
        SHA384(32781),
        SHA512(32782);

        private static final Map<Integer, HashAlgorithm> codeToEnum;
        private final int code;

        static {
            HashMap hashMap = new HashMap();
            for (HashAlgorithm hashAlgorithm : values()) {
                hashMap.put(Integer.valueOf(hashAlgorithm.getCode()), hashAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        HashAlgorithm(int i11) {
            this.code = i11;
        }

        public static HashAlgorithm getAlgorithmByCode(int i11) {
            return codeToEnum.get(Integer.valueOf(i11));
        }

        public int getCode() {
            return this.code;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PKWareExtraHeader(ZipShort zipShort) {
        this.f71243a = zipShort;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i11, int i12) {
        if (i12 >= i11) {
            return;
        }
        throw new ZipException(getClass().getName() + " is too short, only " + i12 + " bytes, expected at least " + i11);
    }

    public void b(byte[] bArr) {
        this.f71245c = u.c(bArr);
    }

    public void c(byte[] bArr) {
        this.f71244b = u.c(bArr);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return this.f71243a;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i11, i12 + i11);
        b(copyOfRange);
        if (this.f71244b == null) {
            c(copyOfRange);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        c(Arrays.copyOfRange(bArr, i11, i12 + i11));
    }
}
