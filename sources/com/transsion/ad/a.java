package com.transsion.ad;

import com.blankj.utilcode.util.Utils;
import java.io.File;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f41834a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f41835b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f41836c;

    static {
        File externalFilesDir = Utils.a().getExternalFilesDir("mb");
        String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        char c11 = File.separatorChar;
        f41835b = absolutePath + c11 + "non_ad";
        File externalFilesDir2 = Utils.a().getExternalFilesDir("ps");
        f41836c = (externalFilesDir2 != null ? externalFilesDir2.getAbsolutePath() : null) + c11 + "non_ad";
    }

    private a() {
    }

    public final String a() {
        return f41836c;
    }

    public final String b() {
        return f41835b;
    }
}
