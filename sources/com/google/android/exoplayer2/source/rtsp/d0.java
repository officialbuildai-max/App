package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class d0 {

    /* renamed from: c, reason: collision with root package name */
    public static final d0 f26393c = new d0(0, C.TIME_UNSET);

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f26394d = Pattern.compile("npt=([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    /* renamed from: a, reason: collision with root package name */
    public final long f26395a;

    /* renamed from: b, reason: collision with root package name */
    public final long f26396b;

    private d0(long j11, long j12) {
        this.f26395a = j11;
        this.f26396b = j12;
    }

    public static String b(long j11) {
        return p0.C("npt=%.3f-", Double.valueOf(j11 / 1000.0d));
    }

    public static d0 d(String str) {
        long parseFloat;
        Matcher matcher = f26394d.matcher(str);
        com.google.android.exoplayer2.util.a.a(matcher.matches());
        long parseFloat2 = ((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))).equals("now") ? 0L : Float.parseFloat(r1) * 1000.0f;
        String group = matcher.group(2);
        if (group != null) {
            try {
                parseFloat = Float.parseFloat(group) * 1000.0f;
                com.google.android.exoplayer2.util.a.a(parseFloat > parseFloat2);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(group, e11);
            }
        } else {
            parseFloat = C.TIME_UNSET;
        }
        return new d0(parseFloat2, parseFloat);
    }

    public long a() {
        return this.f26396b - this.f26395a;
    }

    public boolean c() {
        return this.f26396b == C.TIME_UNSET;
    }
}
