package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class s extends h {

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f27441g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f27442h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f27443i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private s(String str, long j11, long j12, long j13, File file) {
        super(str, j11, j12, j13, file);
    }

    public static s f(File file, long j11, long j12, k kVar) {
        File file2;
        String k11;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File k12 = k(file, kVar);
            if (k12 == null) {
                return null;
            }
            file2 = k12;
            name = k12.getName();
        }
        Matcher matcher = f27443i.matcher(name);
        if (!matcher.matches() || (k11 = kVar.k(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j11 == -1 ? file2.length() : j11;
        if (length == 0) {
            return null;
        }
        return new s(k11, Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), length, j12 == C.TIME_UNSET ? Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))) : j12, file2);
    }

    public static s g(File file, long j11, k kVar) {
        return f(file, j11, C.TIME_UNSET, kVar);
    }

    public static s h(String str, long j11, long j12) {
        return new s(str, j11, j12, C.TIME_UNSET, null);
    }

    public static s i(String str, long j11) {
        return new s(str, j11, -1L, C.TIME_UNSET, null);
    }

    public static File j(File file, int i11, long j11, long j12) {
        return new File(file, i11 + "." + j11 + "." + j12 + ".v3.exo");
    }

    private static File k(File file, k kVar) {
        String str;
        String name = file.getName();
        Matcher matcher = f27442h.matcher(name);
        if (matcher.matches()) {
            str = p0.d1((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        } else {
            matcher = f27441g.matcher(name);
            str = matcher.matches() ? (String) com.google.android.exoplayer2.util.a.e(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        File j11 = j((File) com.google.android.exoplayer2.util.a.i(file.getParentFile()), kVar.f(str), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))));
        if (file.renameTo(j11)) {
            return j11;
        }
        return null;
    }

    public s e(File file, long j11) {
        com.google.android.exoplayer2.util.a.g(this.f27394d);
        return new s(this.f27391a, this.f27392b, this.f27393c, j11, file);
    }
}
