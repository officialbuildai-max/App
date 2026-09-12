package com.avery.subtitle;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import k5.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes2.dex */
public final class SubtitleLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final SubtitleLoader f19962a = new SubtitleLoader();

    /* renamed from: b, reason: collision with root package name */
    private static final String f19963b = SubtitleLoader.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    private static n0 f19964c = o0.a(y0.b());

    /* loaded from: classes2.dex */
    public interface a {
        void a(Exception exc);

        void b(d dVar);
    }

    private SubtitleLoader() {
    }

    private final d c(InputStream inputStream, String str, String str2) {
        String substring = str.substring(StringsKt.v0(str, "/", 0, false, 6, null) + 1);
        Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
        String substring2 = substring.substring(StringsKt.v0(substring, ".", 0, false, 6, null));
        Intrinsics.g(substring2, "this as java.lang.String).substring(startIndex)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parse: name = ");
        sb2.append(substring);
        sb2.append(", ext = ");
        sb2.append(substring2);
        if (StringsKt.H(".srt", substring2, true)) {
            d a11 = new j5.b().a(substring, str2, inputStream);
            Intrinsics.g(a11, "FormatSRT().parseFile(fileName, unicode, `is`)");
            return a11;
        }
        if (StringsKt.H(".ass", substring2, true) || StringsKt.H(".ssa", substring2, true)) {
            d b11 = new j5.a().b(substring, str2, inputStream);
            Intrinsics.g(b11, "FormatASS().parseFile(fileName, unicode, `is`)");
            return b11;
        }
        if (StringsKt.H(".stl", substring2, true)) {
            d b12 = new j5.c().b(substring, str2, inputStream);
            Intrinsics.g(b12, "FormatSTL().parseFile(fileName, unicode, `is`)");
            return b12;
        }
        if (StringsKt.H(".ttml", substring2, true)) {
            d b13 = new j5.c().b(substring, str2, inputStream);
            Intrinsics.g(b13, "FormatSTL().parseFile(fileName, unicode, `is`)");
            return b13;
        }
        if (StringsKt.H(".sub", substring2, true)) {
            return new j5.d().b(substring, str2, inputStream);
        }
        d a12 = new j5.b().a(substring, str2, inputStream);
        Intrinsics.g(a12, "FormatSRT().parseFile(fileName, unicode, `is`)");
        return a12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d d(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parseLocal: localSubtitlePath = ");
        sb2.append(str);
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        String path = file.getPath();
        Intrinsics.g(path, "file.path");
        return c(fileInputStream, path, str2);
    }

    private final void e(String str, String str2, a aVar) {
        k.d(f19964c, null, null, new SubtitleLoader$loadFromLocalAsync$1(str, str2, aVar, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d f(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parseRemote: remoteSubtitlePath = ");
        sb2.append(str);
        URL url = new URL(str);
        InputStream openStream = FirebasePerfUrlConnection.openStream(url);
        Intrinsics.g(openStream, "url.openStream()");
        String path = url.getPath();
        Intrinsics.g(path, "url.path");
        return c(openStream, path, str2);
    }

    private final void g(String str, String str2, a aVar) {
        k.d(f19964c, null, null, new SubtitleLoader$loadFromRemoteAsync$1(str, str2, aVar, null), 3, null);
    }

    public final void h(String path, String unicode, a callback) {
        Intrinsics.h(path, "path");
        Intrinsics.h(unicode, "unicode");
        Intrinsics.h(callback, "callback");
        if (TextUtils.isEmpty(path)) {
            return;
        }
        if (StringsKt.W(path, "http://", false, 2, null) || StringsKt.W(path, "https://", false, 2, null)) {
            g(path, unicode, callback);
        } else {
            e(path, unicode, callback);
        }
    }
}
