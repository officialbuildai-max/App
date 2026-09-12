package com.bytedance.sdk.component.HiB.EjP.TKC.Sj.Sj;

import com.bytedance.sdk.component.HiB.TKC;
import com.bytedance.sdk.component.utils.TEQ;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class sP implements TKC {
    private int Sj;
    private Sj sP;

    public sP(File file, long j11) {
        int i11 = (int) j11;
        this.Sj = i11;
        this.sP = Sj.Sj(i11, file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.HiB.TKC
    public InputStream Sj(String str) {
        Sj sj2 = this.sP;
        if (sj2 == null) {
            return null;
        }
        return sj2.Sj(str);
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public boolean Sj(String str, byte[] bArr) {
        Sj sj2 = this.sP;
        if (sj2 == null || bArr == null || str == null) {
            return false;
        }
        return sj2.Sj(str, bArr);
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public boolean sP(String str) {
        try {
            InputStream Sj = this.sP.Sj(str);
            boolean z10 = Sj != null;
            TEQ.Sj(Sj);
            return z10;
        } catch (Throwable th2) {
            try {
                th2.getMessage();
                return false;
            } finally {
                TEQ.Sj(null);
            }
        }
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    /* renamed from: sP, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] Sj(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        InputStream inputStream;
        Sj sj2 = this.sP;
        if (sj2 != null && str != null) {
            try {
                inputStream = sj2.Sj(str);
                if (inputStream != null) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        } catch (IOException unused) {
                        } catch (Throwable th3) {
                            th2 = th3;
                            TEQ.Sj(inputStream);
                            TEQ.Sj(byteArrayOutputStream);
                            throw th2;
                        }
                    } catch (IOException unused2) {
                        byteArrayOutputStream = null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        byteArrayOutputStream = null;
                        TEQ.Sj(inputStream);
                        TEQ.Sj(byteArrayOutputStream);
                        throw th2;
                    }
                } else {
                    byteArrayOutputStream = null;
                }
                if (byteArrayOutputStream != null) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    TEQ.Sj(inputStream);
                    TEQ.Sj(byteArrayOutputStream);
                    return byteArray;
                }
            } catch (IOException unused3) {
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                byteArrayOutputStream = null;
                th2 = th5;
                inputStream = null;
            }
            TEQ.Sj(inputStream);
            TEQ.Sj(byteArrayOutputStream);
        }
        return null;
    }
}
