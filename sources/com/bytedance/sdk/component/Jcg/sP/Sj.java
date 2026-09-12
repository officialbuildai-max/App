package com.bytedance.sdk.component.Jcg.sP;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bumptech.glide.integration.cronet.BufferQueue;
import com.bytedance.sdk.component.sP.Sj.Fmk;
import com.bytedance.sdk.component.sP.Sj.Ym;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public class Sj extends TKC {
    public File Sj;
    private volatile boolean TEQ;
    public File sP;

    public Sj(Ym ym2) {
        super(ym2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HiB() {
        try {
            this.Sj.delete();
        } catch (Throwable unused) {
        }
        try {
            this.sP.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean HiB(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Jcg(Map<String, String> map) {
        return TextUtils.equals(map.get(HttpHeaders.CONTENT_ENCODING), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long vS(Map<String, String> map) {
        String str = map.containsKey(BufferQueue.CONTENT_LENGTH) ? map.get(BufferQueue.CONTENT_LENGTH) : map.containsKey(HttpHeaders.CONTENT_LENGTH) ? map.get(HttpHeaders.CONTENT_LENGTH) : null;
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x01a2 A[Catch: all -> 0x0232, TryCatch #10 {all -> 0x0232, blocks: (B:69:0x0183, B:71:0x0189, B:73:0x018d, B:74:0x0193, B:75:0x019a, B:77:0x01a2, B:79:0x01b2, B:83:0x01c5, B:87:0x01ce, B:88:0x01d5, B:89:0x01bb, B:93:0x01db, B:100:0x01f3, B:102:0x01fb, B:104:0x0205, B:106:0x020f, B:126:0x0225, B:137:0x01e9), top: B:68:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c9 A[LOOP:1: B:75:0x019a->B:85:0x01c9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.Jcg.sP Sj() {
        /*
            Method dump skipped, instructions count: 605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Jcg.sP.Sj.Sj():com.bytedance.sdk.component.Jcg.sP");
    }

    public void Sj(final com.bytedance.sdk.component.Jcg.Sj.Sj sj2) {
        File file = this.Sj;
        if (file == null || this.sP == null) {
            if (sj2 != null) {
                sj2.Sj(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.Sj.length() != 0 && sj2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.Jcg.sP sPVar = new com.bytedance.sdk.component.Jcg.sP(true, 200, "Success", null, null, currentTimeMillis, currentTimeMillis);
            sPVar.Sj(this.Sj);
            sj2.Sj(this, sPVar);
            return;
        }
        long length = this.sP.length();
        final long j11 = length >= 0 ? length : 0L;
        Fmk.Sj sj3 = new Fmk.Sj();
        sj3.Sj((Object) TKC());
        sP("Range", "bytes=" + j11 + "-");
        if (TextUtils.isEmpty(this.Dq)) {
            sj2.Sj(this, new IOException("Url is Empty"));
            return;
        }
        try {
            sj3.sP(this.Dq);
            if (!TextUtils.isEmpty(this.HiB)) {
                sj3.Sj(this.HiB);
            }
            int i11 = this.vS;
            if (i11 > 0) {
                sj3.Sj(i11);
            }
            Sj(sj3);
            com.bytedance.sdk.component.sP.Sj.sP Sj = this.TKC.Sj(sj3.Sj().sP());
            if (Sj == null) {
                sj2.Sj(this, new IOException("new call error"));
            } else {
                Sj.Sj(new com.bytedance.sdk.component.sP.Sj.TKC() { // from class: com.bytedance.sdk.component.Jcg.sP.Sj.1
                    /* JADX WARN: Removed duplicated region for block: B:101:0x0195 A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x015b  */
                    /* JADX WARN: Removed duplicated region for block: B:66:0x0189 A[LOOP:1: B:55:0x0153->B:66:0x0189, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:67:0x018d A[SYNTHETIC] */
                    @Override // com.bytedance.sdk.component.sP.Sj.TKC
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void Sj(com.bytedance.sdk.component.sP.Sj.sP r19, com.bytedance.sdk.component.sP.Sj.Zq r20) throws java.io.IOException {
                        /*
                            Method dump skipped, instructions count: 597
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.Jcg.sP.Sj.AnonymousClass1.Sj(com.bytedance.sdk.component.sP.Sj.sP, com.bytedance.sdk.component.sP.Sj.Zq):void");
                    }

                    @Override // com.bytedance.sdk.component.sP.Sj.TKC
                    public void Sj(com.bytedance.sdk.component.sP.Sj.sP sPVar2, IOException iOException) {
                        com.bytedance.sdk.component.Jcg.Sj.Sj sj4 = sj2;
                        if (sj4 != null) {
                            sj4.Sj(Sj.this, iOException);
                        }
                        Sj.this.HiB();
                    }
                });
            }
        } catch (IllegalArgumentException unused) {
            sj2.Sj(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    public void Sj(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.Sj = new File(str, str2);
        this.sP = new File(str, str2 + ".temp");
    }

    @Override // com.bytedance.sdk.component.Jcg.sP.TKC
    public void sP() {
        this.TEQ = true;
        super.sP();
    }
}
