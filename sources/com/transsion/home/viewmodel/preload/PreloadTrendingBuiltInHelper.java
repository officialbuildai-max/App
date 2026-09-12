package com.transsion.home.viewmodel.preload;

import android.content.Context;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okio.Okio;

/* loaded from: classes.dex */
public final class PreloadTrendingBuiltInHelper {

    /* renamed from: a, reason: collision with root package name */
    private final String f45934a = "main_operating.json";

    /* renamed from: b, reason: collision with root package name */
    private final String f45935b = "posts.json";

    /* renamed from: c, reason: collision with root package name */
    private final String f45936c = "short_tv_trending.json";

    /* renamed from: d, reason: collision with root package name */
    private final String f45937d = "appTab.json";

    /* renamed from: e, reason: collision with root package name */
    private final String f45938e = "short_tv_new_release.json";

    /* renamed from: f, reason: collision with root package name */
    private final String f45939f = "main_trending.json";

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(String str, String str2, String str3) {
        try {
            if (new File(str + "/" + str2).exists()) {
                return true;
            }
            InputStream open = Utils.a().getAssets().open(str3);
            Intrinsics.g(open, "open(...)");
            FileOutputStream fileOutputStream = new FileOutputStream(str + "/" + str2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    fileOutputStream.close();
                    open.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public final void c(List list) {
        Intrinsics.h(list, "list");
        k.d(o0.a(y0.b()), null, null, new PreloadTrendingBuiltInHelper$copyVideoFiles$1(list, this, null), 3, null);
    }

    public final String d(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getAssets().open(this.f45937d);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String e(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getAssets().open(this.f45934a);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String f(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getAssets().open(this.f45935b);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String g(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getAssets().open(this.f45939f);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }
}
