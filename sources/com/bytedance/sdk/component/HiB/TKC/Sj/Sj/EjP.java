package com.bytedance.sdk.component.HiB.TKC.Sj.Sj;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
final class EjP {
    static final Charset Sj = Charset.forName(C.ASCII_NAME);
    static final Charset sP = Charset.forName("UTF-8");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Sj(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                Sj(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }
}
