package com.transsion.athena.hatnea;

import android.text.TextUtils;
import com.transsion.ga.AthenaAnalytics;
import java.io.File;

/* loaded from: classes5.dex */
public class taaneh extends anateh {

    /* renamed from: c, reason: collision with root package name */
    private final long f42846c;

    /* renamed from: d, reason: collision with root package name */
    private File f42847d;

    /* renamed from: e, reason: collision with root package name */
    private final com.transsion.athena.config.data.model.aethna f42848e;

    public taaneh(long j11, File file, com.transsion.athena.config.data.model.aethna aethnaVar) {
        this.f42846c = j11;
        this.f42847d = file;
        this.f42848e = aethnaVar;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        String str;
        int i11;
        File file = this.f42847d;
        if (file != null && file.exists() && this.f42847d.isFile() && this.f42847d.getName().contains("upload")) {
            File file2 = this.f42847d;
            if (file2.exists()) {
                str = new com.transsion.athena.anateh.aethna(file2.getPath()).a();
                i11 = str.split("\n").length;
            } else {
                str = "";
                i11 = str.split("\n").length;
            }
        } else {
            str = null;
            i11 = 0;
        }
        if (TextUtils.isEmpty(str) || i11 <= 0) {
            return;
        }
        if (anehat.a(this.f42846c, str.getBytes(), i11, this.f42848e).f42830a != 0) {
            com.transsion.athena.taaneh.aethna.b("PostEventFileTask requestByPost error");
        } else if (this.f42847d != null) {
            com.transsion.athena.taaneh.aethna.c("PostEventFileTask lines : %d, deleteFile : %s", Long.valueOf(this.f42846c), Integer.valueOf(i11), Boolean.valueOf(com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J(), this.f42847d)));
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Upload-File";
    }
}
