package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.g0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f26470a = Pattern.compile("([a-z])=\\s?(.+)");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f26471b = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f26472c = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    private static void a(g0.b bVar, a.b bVar2) {
        try {
            bVar.n(bVar2.j());
        } catch (IllegalArgumentException | IllegalStateException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c1, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.source.rtsp.g0 b(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.h0.b(java.lang.String):com.google.android.exoplayer2.source.rtsp.g0");
    }

    private static a.b c(String str) {
        Matcher matcher = f26472c.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw ParserException.createForMalformedManifest(valueOf.length() != 0 ? "Malformed SDP media description line: ".concat(valueOf) : new String("Malformed SDP media description line: "), null);
        }
        try {
            return new a.b((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), (String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(4))));
        } catch (NumberFormatException e11) {
            String valueOf2 = String.valueOf(str);
            throw ParserException.createForMalformedManifest(valueOf2.length() != 0 ? "Malformed SDP media description line: ".concat(valueOf2) : new String("Malformed SDP media description line: "), e11);
        }
    }
}
