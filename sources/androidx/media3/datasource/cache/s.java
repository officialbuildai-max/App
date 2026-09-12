package androidx.media3.datasource.cache;

import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class s extends h {

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f10950g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f10951h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f10952i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private s(String str, long j11, long j12, long j13, File file) {
        super(str, j11, j12, j13, file);
    }

    public static s f(File file, long j11, long j12, k kVar) {
        File file2;
        String i11;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File k11 = k(file, kVar);
            if (k11 == null) {
                return null;
            }
            file2 = k11;
            name = k11.getName();
        }
        Matcher matcher = f10952i.matcher(name);
        if (!matcher.matches() || (i11 = kVar.i(Integer.parseInt((String) androidx.media3.common.util.a.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j11 == -1 ? file2.length() : j11;
        if (length == 0) {
            return null;
        }
        return new s(i11, Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(2))), length, j12 == C.TIME_UNSET ? Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(3))) : j12, file2);
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
        Matcher matcher = f10951h.matcher(name);
        if (matcher.matches()) {
            str = a1.x1((String) androidx.media3.common.util.a.e(matcher.group(1)));
        } else {
            matcher = f10950g.matcher(name);
            str = matcher.matches() ? (String) androidx.media3.common.util.a.e(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        File j11 = j((File) androidx.media3.common.util.a.i(file.getParentFile()), kVar.e(str), Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(2))), Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(3))));
        if (file.renameTo(j11)) {
            return j11;
        }
        return null;
    }

    public s e(File file, long j11) {
        androidx.media3.common.util.a.g(this.f10903d);
        return new s(this.f10900a, this.f10901b, this.f10902c, j11, file);
    }
}
