package com.bytedance.sdk.component.Jcg.sP;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.sP.Sj.Fmk;
import com.bytedance.sdk.component.sP.Sj.Ym;
import com.bytedance.sdk.component.sP.Sj.Zq;
import com.bytedance.sdk.component.sP.Sj.sef;
import com.bytedance.sdk.component.sP.Sj.uA;
import com.bytedance.sdk.component.sP.Sj.uvD;
import com.bytedance.sdk.component.sP.Sj.vS;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class EjP extends TKC {
    sef Sj;

    public EjP(Ym ym2) {
        super(ym2);
        this.Sj = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (r2 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] HiB(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L4c
            int r1 = r5.length()
            if (r1 != 0) goto La
            goto L4c
        La:
            r1 = 0
            byte[] r1 = new byte[r1]
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L42
            r2.<init>()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L42
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L43
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L43
            java.lang.String r0 = "utf-8"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            r3.write(r5)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2e
            r3.close()     // Catch: java.io.IOException -> L23
        L23:
            byte[] r1 = r2.toByteArray()
            r2.close()     // Catch: java.io.IOException -> L4b
            goto L4b
        L2b:
            r5 = move-exception
            r0 = r3
            goto L34
        L2e:
            r0 = r3
            goto L43
        L30:
            r5 = move-exception
            goto L34
        L32:
            r5 = move-exception
            r2 = r0
        L34:
            if (r0 == 0) goto L39
            r0.close()     // Catch: java.io.IOException -> L39
        L39:
            if (r2 == 0) goto L41
            r2.toByteArray()
            r2.close()     // Catch: java.io.IOException -> L41
        L41:
            throw r5
        L42:
            r2 = r0
        L43:
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L48
        L48:
            if (r2 == 0) goto L4b
            goto L23
        L4b:
            return r1
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Jcg.sP.EjP.HiB(java.lang.String):byte[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uA Sj(uvD uvd) {
        try {
            return uvd.HiB();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset Sj(uA uAVar) {
        try {
            return uAVar != null ? uAVar.Sj(com.bytedance.sdk.component.sP.Sj.sP.uA.Sj) : com.bytedance.sdk.component.sP.Sj.sP.uA.Sj;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.sP.Sj.sP.uA.Sj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(com.bytedance.sdk.component.Jcg.sP sPVar, Zq zq2) {
        if (sPVar == null || zq2 == null) {
            return;
        }
        sPVar.Sj(zq2.uA());
    }

    public void EjP(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.Sj = sef.Sj(uA.Sj("application/json; charset=utf-8"), str);
    }

    public com.bytedance.sdk.component.Jcg.sP Sj() {
        com.bytedance.sdk.component.Jcg.sP sPVar;
        try {
            Fmk.Sj sj2 = new Fmk.Sj();
            if (TextUtils.isEmpty(this.Dq)) {
                return new com.bytedance.sdk.component.Jcg.sP(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            sj2.sP(this.Dq);
            if (this.Sj == null) {
                return new com.bytedance.sdk.component.Jcg.sP(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            Sj(sj2);
            sj2.Sj((Object) TKC());
            Zq sP = this.TKC.Sj(sj2.Sj(this.Sj).sP()).sP();
            if (sP == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            vS Jcg = sP.Jcg();
            if (Jcg != null) {
                for (int i11 = 0; i11 < Jcg.Sj(); i11++) {
                    String Sj = Jcg.Sj(i11);
                    String sP2 = Jcg.sP(i11);
                    hashMap.put(Sj, sP2);
                    if (Sj != null && Sj.equalsIgnoreCase("content-type")) {
                        hashMap.put("content-type", sP2 == null ? "" : sP2.toLowerCase());
                    }
                }
            }
            uvD vS = sP.vS();
            if (com.bytedance.sdk.component.Jcg.TKC.Sj.Sj(hashMap)) {
                byte[] EjP = vS.EjP();
                sPVar = new com.bytedance.sdk.component.Jcg.sP(sP.EjP(), sP.TKC(), sP.HiB(), hashMap, null, sP.sP(), sP.Sj());
                sPVar.Sj(EjP);
            } else if (this.uA) {
                byte[] EjP2 = vS.EjP();
                com.bytedance.sdk.component.Jcg.sP sPVar2 = new com.bytedance.sdk.component.Jcg.sP(sP.EjP(), sP.TKC(), sP.HiB(), hashMap, new String(EjP2, Sj(Sj(vS))), sP.sP(), sP.Sj());
                sPVar2.Sj(EjP2);
                sPVar = sPVar2;
            } else {
                if (vS == null) {
                    throw new IOException(sP.HiB());
                }
                sPVar = new com.bytedance.sdk.component.Jcg.sP(sP.EjP(), sP.TKC(), sP.HiB(), hashMap, vS.sP(), sP.sP(), sP.Sj());
            }
            Sj(sPVar, sP);
            return sPVar;
        } catch (Throwable th2) {
            return new com.bytedance.sdk.component.Jcg.sP(false, 5001, th2.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    public void Sj(final com.bytedance.sdk.component.Jcg.Sj.Sj sj2) {
        try {
            Fmk.Sj sj3 = new Fmk.Sj();
            if (TextUtils.isEmpty(this.Dq)) {
                sj2.Sj(this, new IOException("Url is Empty"));
                return;
            }
            if (!TextUtils.isEmpty(this.HiB)) {
                sj3.Sj(this.HiB);
            }
            int i11 = this.vS;
            if (i11 > 0) {
                sj3.Sj(i11);
            }
            sj3.sP(this.Dq);
            if (this.Sj == null) {
                if (sj2 != null) {
                    sj2.Sj(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                Sj(sj3);
                sj3.Sj((Object) TKC());
                this.TKC.Sj(sj3.Sj(this.Sj).sP()).Sj(new com.bytedance.sdk.component.sP.Sj.TKC() { // from class: com.bytedance.sdk.component.Jcg.sP.EjP.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:34:0x00f5  */
                    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
                    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.sdk.component.Jcg.Sj.Sj] */
                    /* JADX WARN: Type inference failed for: r14v0 */
                    /* JADX WARN: Type inference failed for: r14v1, types: [com.bytedance.sdk.component.Jcg.sP] */
                    /* JADX WARN: Type inference failed for: r14v10 */
                    /* JADX WARN: Type inference failed for: r14v4 */
                    /* JADX WARN: Type inference failed for: r14v5 */
                    /* JADX WARN: Type inference failed for: r14v6, types: [com.bytedance.sdk.component.Jcg.sP] */
                    /* JADX WARN: Type inference failed for: r14v7, types: [com.bytedance.sdk.component.Jcg.sP] */
                    /* JADX WARN: Type inference failed for: r14v8 */
                    /* JADX WARN: Type inference failed for: r14v9 */
                    /* JADX WARN: Type inference failed for: r15v1, types: [com.bytedance.sdk.component.Jcg.sP] */
                    @Override // com.bytedance.sdk.component.sP.Sj.TKC
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void Sj(com.bytedance.sdk.component.sP.Sj.sP r17, com.bytedance.sdk.component.sP.Sj.Zq r18) throws java.io.IOException {
                        /*
                            Method dump skipped, instructions count: 317
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Jcg.sP.EjP.AnonymousClass1.Sj(com.bytedance.sdk.component.sP.Sj.sP, com.bytedance.sdk.component.sP.Sj.Zq):void");
                    }

                    @Override // com.bytedance.sdk.component.sP.Sj.TKC
                    public void Sj(com.bytedance.sdk.component.sP.Sj.sP sPVar, IOException iOException) {
                        com.bytedance.sdk.component.Jcg.Sj.Sj sj4 = sj2;
                        if (sj4 != null) {
                            sj4.Sj(EjP.this, iOException);
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            sj2.Sj(this, new IOException(th2.getMessage()));
        }
    }

    public void Sj(String str, boolean z10) {
        if (!z10) {
            EjP(str);
        } else {
            Sj("application/json; charset=utf-8", HiB(str));
            sP(HttpHeaders.CONTENT_ENCODING, "gzip");
        }
    }

    public void Sj(String str, byte[] bArr) {
        this.Sj = sef.Sj(uA.Sj(str), bArr);
    }

    public void Sj(JSONObject jSONObject) {
        this.Sj = sef.Sj(uA.Sj("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }
}
