package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.h;
import androidx.media3.common.util.a1;
import androidx.media3.common.y;
import androidx.media3.exoplayer.hls.playlist.c;
import androidx.media3.exoplayer.hls.playlist.d;
import androidx.media3.exoplayer.upstream.q;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import f3.p;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class HlsPlaylistParser implements q.a {

    /* renamed from: a, reason: collision with root package name */
    private final d f11917a;

    /* renamed from: b, reason: collision with root package name */
    private final c f11918b;

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f11876c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f11878d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f11880e = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f11882f = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f11884g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f11886h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f11888i = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f11890j = Pattern.compile("VIDEO-RANGE=(SDR|PQ|HLG)");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f11892k = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f11894l = Pattern.compile("SUPPLEMENTAL-CODECS=\"(.+?)\"");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f11896m = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f11898n = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: o, reason: collision with root package name */
    private static final Pattern f11900o = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: p, reason: collision with root package name */
    private static final Pattern f11902p = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f11904q = Pattern.compile("[:,]DURATION=([\\d\\.]+)\\b");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f11906r = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: s, reason: collision with root package name */
    private static final Pattern f11908s = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: t, reason: collision with root package name */
    private static final Pattern f11910t = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: u, reason: collision with root package name */
    private static final Pattern f11911u = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: v, reason: collision with root package name */
    private static final Pattern f11912v = b("CAN-SKIP-DATERANGES");

    /* renamed from: w, reason: collision with root package name */
    private static final Pattern f11913w = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: x, reason: collision with root package name */
    private static final Pattern f11914x = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: y, reason: collision with root package name */
    private static final Pattern f11915y = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: z, reason: collision with root package name */
    private static final Pattern f11916z = b("CAN-BLOCK-RELOAD");
    private static final Pattern A = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern B = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern C = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern D = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern E = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern F = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern G = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern H = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern I = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern J = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern K = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern L = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern M = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern N = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern O = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern P = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern Q = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern R = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern S = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern T = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern U = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern V = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern W = b("AUTOSELECT");
    private static final Pattern X = b("DEFAULT");
    private static final Pattern Y = b("FORCED");
    private static final Pattern Z = b("INDEPENDENT");

    /* renamed from: a0, reason: collision with root package name */
    private static final Pattern f11874a0 = b("GAP");

    /* renamed from: b0, reason: collision with root package name */
    private static final Pattern f11875b0 = b("PRECISE");

    /* renamed from: c0, reason: collision with root package name */
    private static final Pattern f11877c0 = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: d0, reason: collision with root package name */
    private static final Pattern f11879d0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: e0, reason: collision with root package name */
    private static final Pattern f11881e0 = Pattern.compile("[:,]ID=\"(.+?)\"");

    /* renamed from: f0, reason: collision with root package name */
    private static final Pattern f11883f0 = Pattern.compile("CLASS=\"(.+?)\"");

    /* renamed from: g0, reason: collision with root package name */
    private static final Pattern f11885g0 = Pattern.compile("START-DATE=\"(.+?)\"");

    /* renamed from: h0, reason: collision with root package name */
    private static final Pattern f11887h0 = Pattern.compile("CUE=\"(.+?)\"");

    /* renamed from: i0, reason: collision with root package name */
    private static final Pattern f11889i0 = Pattern.compile("END-DATE=\"(.+?)\"");

    /* renamed from: j0, reason: collision with root package name */
    private static final Pattern f11891j0 = Pattern.compile("PLANNED-DURATION=([\\d\\.]+)\\b");

    /* renamed from: k0, reason: collision with root package name */
    private static final Pattern f11893k0 = b("END-ON-NEXT");

    /* renamed from: l0, reason: collision with root package name */
    private static final Pattern f11895l0 = Pattern.compile("X-ASSET-URI=\"(.+?)\"");

    /* renamed from: m0, reason: collision with root package name */
    private static final Pattern f11897m0 = Pattern.compile("X-ASSET-LIST=\"(.+?)\"");

    /* renamed from: n0, reason: collision with root package name */
    private static final Pattern f11899n0 = Pattern.compile("X-RESUME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: o0, reason: collision with root package name */
    private static final Pattern f11901o0 = Pattern.compile("X-PLAYOUT-LIMIT=([\\d\\.]+)\\b");

    /* renamed from: p0, reason: collision with root package name */
    private static final Pattern f11903p0 = Pattern.compile("X-SNAP=\"(.+?)\"");

    /* renamed from: q0, reason: collision with root package name */
    private static final Pattern f11905q0 = Pattern.compile("X-RESTRICT=\"(.+?)\"");

    /* renamed from: r0, reason: collision with root package name */
    private static final Pattern f11907r0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: s0, reason: collision with root package name */
    private static final Pattern f11909s0 = Pattern.compile("\\b(X-[A-Z0-9-]+)=");

    /* loaded from: classes2.dex */
    public static final class DeltaUpdateException extends IOException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedReader f11919a;

        /* renamed from: b, reason: collision with root package name */
        private final Queue f11920b;

        /* renamed from: c, reason: collision with root package name */
        private String f11921c;

        public a(Queue queue, BufferedReader bufferedReader) {
            this.f11920b = queue;
            this.f11919a = bufferedReader;
        }

        public boolean a() {
            String trim;
            if (this.f11921c != null) {
                return true;
            }
            if (!this.f11920b.isEmpty()) {
                this.f11921c = (String) androidx.media3.common.util.a.e((String) this.f11920b.poll());
                return true;
            }
            do {
                String readLine = this.f11919a.readLine();
                this.f11921c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f11921c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.f11921c;
            this.f11921c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(d.f12014n, null);
    }

    public HlsPlaylistParser(d dVar, c cVar) {
        this.f11917a = dVar;
        this.f11918b = cVar;
    }

    private static String A(String str, Pattern pattern, Map map) {
        String w11 = w(str, pattern, map);
        if (w11 != null) {
            return w11;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    private static long B(String str, Pattern pattern) {
        return new BigDecimal(A(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    private static String C(String str, Map map) {
        Matcher matcher = f11907r0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int D(BufferedReader bufferedReader, boolean z10, int i11) {
        while (i11 != -1 && Character.isWhitespace(i11) && (z10 || !a1.I0(i11))) {
            i11 = bufferedReader.read();
        }
        return i11;
    }

    private static boolean a(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int D2 = D(bufferedReader, true, read);
        for (int i11 = 0; i11 < 7; i11++) {
            if (D2 != "#EXTM3U".charAt(i11)) {
                return false;
            }
            D2 = bufferedReader.read();
        }
        return a1.I0(D(bufferedReader, false, D2));
    }

    private static Pattern b(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    private static DrmInitData c(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i11 = 0; i11 < schemeDataArr.length; i11++) {
            schemeDataArr2[i11] = schemeDataArr[i11].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String d(long j11, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j11);
    }

    private static d.b e(ArrayList arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            d.b bVar = (d.b) arrayList.get(i11);
            if (str.equals(bVar.f12032d)) {
                return bVar;
            }
        }
        return null;
    }

    private static d.b f(ArrayList arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            d.b bVar = (d.b) arrayList.get(i11);
            if (str.equals(bVar.f12033e)) {
                return bVar;
            }
        }
        return null;
    }

    private static d.b g(ArrayList arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            d.b bVar = (d.b) arrayList.get(i11);
            if (str.equals(bVar.f12031c)) {
                return bVar;
            }
        }
        return null;
    }

    private static boolean h(String str, String str2, String str3, String str4) {
        if (!y.p(str2, str3)) {
            return false;
        }
        if (str3 == null) {
            return true;
        }
        if (str == null || str4 == null) {
            return false;
        }
        return (!str.equals("PQ") || str4.equals("db1p")) && (!str.equals("SDR") || str4.equals("db2g")) && (!str.equals("HLG") || str4.startsWith("db4"));
    }

    private static c.b j(String str, String str2, Map map) {
        String str3 = str2 + UrlUtils.EQUAL_MARK;
        int indexOf = str.indexOf(str3) + str3.length();
        String substring = str.substring(indexOf, (str.length() == indexOf + 1 ? 1 : 2) + indexOf);
        if (substring.startsWith("\"")) {
            return new c.b(str2, A(str, Pattern.compile(str2 + "=\"(.+?)\""), map), 0);
        }
        if (substring.equals("0x") || substring.equals("0X")) {
            return new c.b(str2, A(str, Pattern.compile(str2 + "=(0[xX][A-F0-9]+)"), map), 1);
        }
        return new c.b(str2, k(str, Pattern.compile(str2 + "=([\\d\\.]+)\\b")));
    }

    private static double k(String str, Pattern pattern) {
        return Double.parseDouble(A(str, pattern, Collections.emptyMap()));
    }

    private static DrmInitData.SchemeData l(String str, String str2, Map map) {
        String v11 = v(str, M, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String A2 = A(str, N, map);
            return new DrmInitData.SchemeData(h.f10066d, MimeTypes.VIDEO_MP4, Base64.decode(A2.substring(A2.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(h.f10066d, "hls", a1.u0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(v11)) {
            return null;
        }
        String A3 = A(str, N, map);
        byte[] decode = Base64.decode(A3.substring(A3.indexOf(44)), 0);
        UUID uuid = h.f10067e;
        return new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, p.a(uuid, decode));
    }

    private static String m(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? C.CENC_TYPE_cenc : C.CENC_TYPE_cbcs;
    }

    private static int n(String str, Pattern pattern) {
        return Integer.parseInt(A(str, pattern, Collections.emptyMap()));
    }

    private static long o(String str, Pattern pattern) {
        return Long.parseLong(A(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x0655  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.media3.exoplayer.hls.playlist.c p(androidx.media3.exoplayer.hls.playlist.d r117, androidx.media3.exoplayer.hls.playlist.c r118, androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.a r119, java.lang.String r120) {
        /*
            Method dump skipped, instructions count: 2578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.p(androidx.media3.exoplayer.hls.playlist.d, androidx.media3.exoplayer.hls.playlist.c, androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser$a, java.lang.String):androidx.media3.exoplayer.hls.playlist.c");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0190, code lost:
    
        if (r3 > 0) goto L55;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:99:0x0399. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a1  */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.media3.exoplayer.hls.playlist.d q(androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.a r36, java.lang.String r37) {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.q(androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser$a, java.lang.String):androidx.media3.exoplayer.hls.playlist.d");
    }

    private static boolean r(String str, Pattern pattern, boolean z10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z10;
    }

    private static double s(String str, Pattern pattern, double d11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) androidx.media3.common.util.a.e(matcher.group(1))) : d11;
    }

    private static int t(String str, Pattern pattern, int i11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) androidx.media3.common.util.a.e(matcher.group(1))) : i11;
    }

    private static long u(String str, Pattern pattern, long j11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(1))) : j11;
    }

    private static String v(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) androidx.media3.common.util.a.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : C(str2, map);
    }

    private static String w(String str, Pattern pattern, Map map) {
        return v(str, pattern, null, map);
    }

    private static int x(String str, Map map) {
        String w11 = w(str, U, map);
        if (TextUtils.isEmpty(w11)) {
            return 0;
        }
        String[] o12 = a1.o1(w11, ",");
        int i11 = a1.s(o12, "public.accessibility.describes-video") ? 512 : 0;
        if (a1.s(o12, "public.accessibility.transcribes-spoken-dialog")) {
            i11 |= 4096;
        }
        if (a1.s(o12, "public.accessibility.describes-music-and-sound")) {
            i11 |= 1024;
        }
        return a1.s(o12, "public.easy-to-read") ? i11 | 8192 : i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int y(String str) {
        boolean r11 = r(str, X, false);
        ?? r02 = r11;
        if (r(str, Y, false)) {
            r02 = (r11 ? 1 : 0) | 2;
        }
        return r(str, W, false) ? r02 | 4 : r02;
    }

    private static c.h z(String str) {
        double s11 = s(str, f11911u, -9.223372036854776E18d);
        long j11 = C.TIME_UNSET;
        long j12 = s11 == -9.223372036854776E18d ? -9223372036854775807L : (long) (s11 * 1000000.0d);
        boolean r11 = r(str, f11912v, false);
        double s12 = s(str, f11914x, -9.223372036854776E18d);
        long j13 = s12 == -9.223372036854776E18d ? -9223372036854775807L : (long) (s12 * 1000000.0d);
        double s13 = s(str, f11915y, -9.223372036854776E18d);
        if (s13 != -9.223372036854776E18d) {
            j11 = (long) (s13 * 1000000.0d);
        }
        return new c.h(j12, r11, j13, j11, r(str, f11916z, false));
    }

    @Override // androidx.media3.exoplayer.upstream.q.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c2.d parse(Uri uri, InputStream inputStream) {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!a(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    a1.m(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                trim = readLine.trim();
                if (!trim.isEmpty()) {
                    if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                        if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                            break;
                        }
                        arrayDeque.add(trim);
                    } else {
                        arrayDeque.add(trim);
                        return q(new a(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(trim);
            return p(this.f11917a, this.f11918b, new a(arrayDeque, bufferedReader), uri.toString());
        } finally {
            a1.m(bufferedReader);
        }
    }
}
