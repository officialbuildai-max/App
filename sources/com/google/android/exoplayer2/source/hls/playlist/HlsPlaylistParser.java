package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class HlsPlaylistParser implements b0.a {

    /* renamed from: a, reason: collision with root package name */
    private final e f26142a;

    /* renamed from: b, reason: collision with root package name */
    private final d f26143b;

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f26118c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f26119d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f26120e = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f26121f = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f26122g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f26123h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f26124i = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f26125j = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f26126k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f26127l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f26128m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f26129n = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: o, reason: collision with root package name */
    private static final Pattern f26130o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: p, reason: collision with root package name */
    private static final Pattern f26131p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f26132q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f26133r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: s, reason: collision with root package name */
    private static final Pattern f26134s = b("CAN-SKIP-DATERANGES");

    /* renamed from: t, reason: collision with root package name */
    private static final Pattern f26135t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: u, reason: collision with root package name */
    private static final Pattern f26136u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: v, reason: collision with root package name */
    private static final Pattern f26137v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: w, reason: collision with root package name */
    private static final Pattern f26138w = b("CAN-BLOCK-RELOAD");

    /* renamed from: x, reason: collision with root package name */
    private static final Pattern f26139x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: y, reason: collision with root package name */
    private static final Pattern f26140y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: z, reason: collision with root package name */
    private static final Pattern f26141z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern A = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern B = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern K = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern L = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern N = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern O = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern P = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern T = b("AUTOSELECT");
    private static final Pattern U = b("DEFAULT");
    private static final Pattern V = b("FORCED");
    private static final Pattern W = b("INDEPENDENT");
    private static final Pattern X = b("GAP");
    private static final Pattern Y = b("PRECISE");
    private static final Pattern Z = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: a0, reason: collision with root package name */
    private static final Pattern f26116a0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: b0, reason: collision with root package name */
    private static final Pattern f26117b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* loaded from: classes3.dex */
    public static final class DeltaUpdateException extends IOException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final BufferedReader f26144a;

        /* renamed from: b, reason: collision with root package name */
        private final Queue f26145b;

        /* renamed from: c, reason: collision with root package name */
        private String f26146c;

        public a(Queue queue, BufferedReader bufferedReader) {
            this.f26145b = queue;
            this.f26144a = bufferedReader;
        }

        public boolean a() {
            String trim;
            if (this.f26146c != null) {
                return true;
            }
            if (!this.f26145b.isEmpty()) {
                this.f26146c = (String) com.google.android.exoplayer2.util.a.e((String) this.f26145b.poll());
                return true;
            }
            do {
                String readLine = this.f26144a.readLine();
                this.f26146c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f26146c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.f26146c;
            this.f26146c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(e.f26219n, null);
    }

    public HlsPlaylistParser(e eVar, d dVar) {
        this.f26142a = eVar;
        this.f26143b = dVar;
    }

    private static String A(String str, Map map) {
        Matcher matcher = f26117b0.matcher(str);
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

    private static int B(BufferedReader bufferedReader, boolean z10, int i11) {
        while (i11 != -1 && Character.isWhitespace(i11) && (z10 || !p0.v0(i11))) {
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
        int B2 = B(bufferedReader, true, read);
        for (int i11 = 0; i11 < 7; i11++) {
            if (B2 != "#EXTM3U".charAt(i11)) {
                return false;
            }
            B2 = bufferedReader.read();
        }
        return p0.v0(B(bufferedReader, false, B2));
    }

    private static Pattern b(String str) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 9);
        sb2.append(str);
        sb2.append("=(");
        sb2.append("NO");
        sb2.append("|");
        sb2.append("YES");
        sb2.append(")");
        return Pattern.compile(sb2.toString());
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

    private static e.b e(ArrayList arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            e.b bVar = (e.b) arrayList.get(i11);
            if (str.equals(bVar.f26237d)) {
                return bVar;
            }
        }
        return null;
    }

    private static e.b f(ArrayList arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            e.b bVar = (e.b) arrayList.get(i11);
            if (str.equals(bVar.f26238e)) {
                return bVar;
            }
        }
        return null;
    }

    private static e.b g(ArrayList arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            e.b bVar = (e.b) arrayList.get(i11);
            if (str.equals(bVar.f26236c)) {
                return bVar;
            }
        }
        return null;
    }

    private static double i(String str, Pattern pattern) {
        return Double.parseDouble(y(str, pattern, Collections.emptyMap()));
    }

    private static DrmInitData.SchemeData j(String str, String str2, Map map) {
        String t11 = t(str, J, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String y10 = y(str, K, map);
            return new DrmInitData.SchemeData(l.f25243d, MimeTypes.VIDEO_MP4, Base64.decode(y10.substring(y10.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(l.f25243d, "hls", p0.n0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(t11)) {
            return null;
        }
        String y11 = y(str, K, map);
        byte[] decode = Base64.decode(y11.substring(y11.indexOf(44)), 0);
        UUID uuid = l.f25244e;
        return new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, o9.l.a(uuid, decode));
    }

    private static String k(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? C.CENC_TYPE_cenc : C.CENC_TYPE_cbcs;
    }

    private static int l(String str, Pattern pattern) {
        return Integer.parseInt(y(str, pattern, Collections.emptyMap()));
    }

    private static long m(String str, Pattern pattern) {
        return Long.parseLong(y(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static d n(e eVar, d dVar, a aVar, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        long j11;
        boolean z10;
        int i11;
        d.b bVar;
        int i12;
        String u11;
        long j12;
        long j13;
        long j14;
        long j15;
        boolean z11;
        Object obj;
        e eVar2 = eVar;
        d dVar2 = dVar;
        boolean z12 = eVar2.f79075c;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        d.f fVar = new d.f(C.TIME_UNSET, false, C.TIME_UNSET, C.TIME_UNSET, false);
        TreeMap treeMap = new TreeMap();
        boolean z13 = false;
        String str3 = "";
        boolean z14 = z12;
        d.f fVar2 = fVar;
        int i13 = 0;
        boolean z15 = false;
        boolean z16 = false;
        int i14 = 0;
        boolean z17 = false;
        boolean z18 = false;
        int i15 = 0;
        boolean z19 = false;
        String str4 = str3;
        String str5 = null;
        long j16 = C.TIME_UNSET;
        long j17 = 0;
        long j18 = 0;
        int i16 = 1;
        long j19 = C.TIME_UNSET;
        long j20 = C.TIME_UNSET;
        DrmInitData drmInitData = null;
        long j21 = 0;
        Object obj2 = null;
        long j22 = 0;
        long j23 = -1;
        String str6 = null;
        String str7 = null;
        long j24 = 0;
        long j25 = 0;
        d.C0374d c0374d = null;
        long j26 = 0;
        long j27 = 0;
        ArrayList arrayList7 = arrayList4;
        d.b bVar2 = null;
        while (aVar.a()) {
            String b11 = aVar.b();
            if (b11.startsWith("#EXT")) {
                arrayList6.add(b11);
            }
            if (b11.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String y10 = y(b11, f26132q, hashMap);
                if ("VOD".equals(y10)) {
                    i13 = 1;
                } else if ("EVENT".equals(y10)) {
                    i13 = 2;
                }
            } else if (b11.equals("#EXT-X-I-FRAMES-ONLY")) {
                z19 = true;
            } else if (b11.startsWith("#EXT-X-START")) {
                j16 = (long) (i(b11, C) * 1000000.0d);
                z15 = p(b11, Y, z13);
            } else if (b11.startsWith("#EXT-X-SERVER-CONTROL")) {
                fVar2 = x(b11);
            } else if (b11.startsWith("#EXT-X-PART-INF")) {
                j20 = (long) (i(b11, f26130o) * 1000000.0d);
            } else if (b11.startsWith("#EXT-X-MAP")) {
                String y11 = y(b11, K, hashMap);
                String u12 = u(b11, E, hashMap);
                if (u12 != null) {
                    String[] S0 = p0.S0(u12, "@");
                    j23 = Long.parseLong(S0[z13 ? 1 : 0]);
                    if (S0.length > 1) {
                        j21 = Long.parseLong(S0[1]);
                    }
                }
                if (j23 == -1) {
                    j21 = 0;
                }
                String str8 = str6;
                if (str5 != null && str8 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                c0374d = new d.C0374d(y11, j21, j23, str5, str8);
                if (j23 != -1) {
                    j21 += j23;
                }
                str6 = str8;
                j23 = -1;
            } else {
                String str9 = str6;
                if (b11.startsWith("#EXT-X-TARGETDURATION")) {
                    j19 = 1000000 * l(b11, f26128m);
                } else {
                    if (b11.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        j25 = m(b11, f26139x);
                        str6 = str9;
                        j18 = j25;
                    } else if (b11.startsWith("#EXT-X-VERSION")) {
                        i16 = l(b11, f26131p);
                    } else {
                        if (b11.startsWith("#EXT-X-DEFINE")) {
                            String u13 = u(b11, f26116a0, hashMap);
                            if (u13 != null) {
                                String str10 = (String) eVar2.f26228l.get(u13);
                                if (str10 != null) {
                                    hashMap.put(u13, str10);
                                }
                            } else {
                                hashMap.put(y(b11, P, hashMap), y(b11, Z, hashMap));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = str7;
                            j11 = j25;
                            z10 = false;
                            i11 = i13;
                        } else if (b11.startsWith("#EXTINF")) {
                            j26 = z(b11, f26140y);
                            str4 = t(b11, f26141z, str3, hashMap);
                        } else {
                            String str11 = str3;
                            if (b11.startsWith("#EXT-X-SKIP")) {
                                int l11 = l(b11, f26135t);
                                com.google.android.exoplayer2.util.a.g(dVar2 != null && arrayList3.isEmpty());
                                int i17 = (int) (j18 - ((d) p0.j(dVar)).f26184k);
                                int i18 = l11 + i17;
                                if (i17 < 0 || i18 > dVar2.f26191r.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str3 = str11;
                                String str12 = str9;
                                long j28 = j24;
                                while (i17 < i18) {
                                    d.C0374d c0374d2 = (d.C0374d) dVar2.f26191r.get(i17);
                                    ArrayList arrayList8 = arrayList7;
                                    ArrayList arrayList9 = arrayList6;
                                    if (j18 != dVar2.f26184k) {
                                        c0374d2 = c0374d2.b(j28, (dVar2.f26183j - i14) + c0374d2.f26206d);
                                    }
                                    arrayList3.add(c0374d2);
                                    j28 += c0374d2.f26205c;
                                    long j29 = c0374d2.f26212j;
                                    if (j29 != -1) {
                                        i12 = i18;
                                        j21 = c0374d2.f26211i + j29;
                                    } else {
                                        i12 = i18;
                                    }
                                    int i19 = c0374d2.f26206d;
                                    d.C0374d c0374d3 = c0374d2.f26204b;
                                    DrmInitData drmInitData2 = c0374d2.f26208f;
                                    String str13 = c0374d2.f26209g;
                                    String str14 = c0374d2.f26210h;
                                    if (str14 == null || !str14.equals(Long.toHexString(j25))) {
                                        str12 = c0374d2.f26210h;
                                    }
                                    j25++;
                                    i17++;
                                    dVar2 = dVar;
                                    obj2 = drmInitData2;
                                    str5 = str13;
                                    j22 = j28;
                                    i18 = i12;
                                    i15 = i19;
                                    c0374d = c0374d3;
                                    arrayList7 = arrayList8;
                                    arrayList6 = arrayList9;
                                }
                                eVar2 = eVar;
                                dVar2 = dVar;
                                j24 = j28;
                                str6 = str12;
                            } else {
                                ArrayList arrayList10 = arrayList7;
                                arrayList2 = arrayList6;
                                str3 = str11;
                                if (b11.startsWith("#EXT-X-KEY")) {
                                    String y12 = y(b11, H, hashMap);
                                    String t11 = t(b11, I, "identity", hashMap);
                                    if ("NONE".equals(y12)) {
                                        treeMap.clear();
                                        u11 = null;
                                        str5 = null;
                                    } else {
                                        u11 = u(b11, L, hashMap);
                                        if (!"identity".equals(t11)) {
                                            String str15 = str7;
                                            str7 = str15 == null ? k(y12) : str15;
                                            DrmInitData.SchemeData j30 = j(b11, t11, hashMap);
                                            if (j30 != null) {
                                                treeMap.put(t11, j30);
                                                str5 = null;
                                            }
                                        } else if ("AES-128".equals(y12)) {
                                            str5 = y(b11, K, hashMap);
                                            eVar2 = eVar;
                                            dVar2 = dVar;
                                            str6 = u11;
                                        }
                                        str5 = null;
                                        eVar2 = eVar;
                                        dVar2 = dVar;
                                        str6 = u11;
                                    }
                                    obj2 = str5;
                                    eVar2 = eVar;
                                    dVar2 = dVar;
                                    str6 = u11;
                                } else {
                                    String str16 = str7;
                                    if (b11.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] S02 = p0.S0(y(b11, D, hashMap), "@");
                                        j23 = Long.parseLong(S02[0]);
                                        if (S02.length > 1) {
                                            j21 = Long.parseLong(S02[1]);
                                        }
                                    } else if (b11.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i14 = Integer.parseInt(b11.substring(b11.indexOf(58) + 1));
                                        eVar2 = eVar;
                                        dVar2 = dVar;
                                        str7 = str16;
                                        str6 = str9;
                                        arrayList7 = arrayList10;
                                        arrayList6 = arrayList2;
                                        z13 = false;
                                        z16 = true;
                                    } else if (b11.equals("#EXT-X-DISCONTINUITY")) {
                                        i15++;
                                    } else {
                                        if (b11.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (j17 == 0) {
                                                j17 = p0.B0(p0.I0(b11.substring(b11.indexOf(58) + 1))) - j24;
                                            } else {
                                                i11 = i13;
                                                str2 = str16;
                                            }
                                        } else if (b11.equals("#EXT-X-GAP")) {
                                            eVar2 = eVar;
                                            dVar2 = dVar;
                                            str7 = str16;
                                            str6 = str9;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z13 = false;
                                            z18 = true;
                                        } else if (b11.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            eVar2 = eVar;
                                            dVar2 = dVar;
                                            str7 = str16;
                                            str6 = str9;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z13 = false;
                                            z14 = true;
                                        } else if (b11.equals("#EXT-X-ENDLIST")) {
                                            eVar2 = eVar;
                                            dVar2 = dVar;
                                            str7 = str16;
                                            str6 = str9;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z13 = false;
                                            z17 = true;
                                        } else if (b11.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i11 = i13;
                                            str2 = str16;
                                            arrayList5.add(new d.c(Uri.parse(n0.d(str, y(b11, K, hashMap))), s(b11, A, -1L), r(b11, B, -1)));
                                        } else {
                                            i11 = i13;
                                            str2 = str16;
                                            if (!b11.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                j11 = j25;
                                                if (b11.startsWith("#EXT-X-PART")) {
                                                    String d11 = d(j11, str5, str9);
                                                    String y13 = y(b11, K, hashMap);
                                                    long i20 = (long) (i(b11, f26129n) * 1000000.0d);
                                                    d.b bVar3 = bVar2;
                                                    boolean p11 = p(b11, W, false) | (z14 && arrayList10.isEmpty());
                                                    boolean p12 = p(b11, X, false);
                                                    String u14 = u(b11, E, hashMap);
                                                    if (u14 != null) {
                                                        String[] S03 = p0.S0(u14, "@");
                                                        j13 = Long.parseLong(S03[0]);
                                                        if (S03.length > 1) {
                                                            j27 = Long.parseLong(S03[1]);
                                                        }
                                                        j12 = -1;
                                                    } else {
                                                        j12 = -1;
                                                        j13 = -1;
                                                    }
                                                    if (j13 == j12) {
                                                        j27 = 0;
                                                    }
                                                    if (obj2 == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData3 = new DrmInitData(str2, schemeDataArr);
                                                        if (drmInitData == null) {
                                                            drmInitData = c(str2, schemeDataArr);
                                                        }
                                                        obj2 = drmInitData3;
                                                    }
                                                    arrayList10.add(new d.b(y13, c0374d, i20, i15, j22, obj2, str5, d11, j27, j13, p12, p11, false));
                                                    j22 += i20;
                                                    if (j13 != j12) {
                                                        j27 += j13;
                                                    }
                                                    eVar2 = eVar;
                                                    dVar2 = dVar;
                                                    str6 = str9;
                                                    i13 = i11;
                                                    bVar2 = bVar3;
                                                    j25 = j11;
                                                    str7 = str2;
                                                    arrayList7 = arrayList10;
                                                    arrayList6 = arrayList2;
                                                } else {
                                                    bVar = bVar2;
                                                    arrayList = arrayList10;
                                                    if (b11.startsWith(Utils.SEPARATOR)) {
                                                        z10 = false;
                                                        eVar2 = eVar;
                                                        str6 = str9;
                                                        i13 = i11;
                                                        bVar2 = bVar;
                                                        j25 = j11;
                                                        str7 = str2;
                                                        arrayList7 = arrayList;
                                                        arrayList6 = arrayList2;
                                                        z13 = z10;
                                                        dVar2 = dVar;
                                                    } else {
                                                        String d12 = d(j11, str5, str9);
                                                        long j31 = j11 + 1;
                                                        String A2 = A(b11, hashMap);
                                                        d.C0374d c0374d4 = (d.C0374d) hashMap2.get(A2);
                                                        if (j23 == -1) {
                                                            j14 = 0;
                                                        } else {
                                                            if (z19 && c0374d == null && c0374d4 == null) {
                                                                c0374d4 = new d.C0374d(A2, 0L, j21, null, null);
                                                                hashMap2.put(A2, c0374d4);
                                                            }
                                                            j14 = j21;
                                                        }
                                                        if (obj2 != null || treeMap.isEmpty()) {
                                                            j15 = j31;
                                                            z11 = false;
                                                            obj = obj2;
                                                        } else {
                                                            j15 = j31;
                                                            z11 = false;
                                                            DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            obj = new DrmInitData(str2, schemeDataArr2);
                                                            if (drmInitData == null) {
                                                                drmInitData = c(str2, schemeDataArr2);
                                                            }
                                                        }
                                                        arrayList3.add(new d.C0374d(A2, c0374d != null ? c0374d : c0374d4, str4, j26, i15, j24, obj, str5, d12, j14, j23, z18, arrayList));
                                                        j22 = j24 + j26;
                                                        arrayList7 = new ArrayList();
                                                        if (j23 != -1) {
                                                            j14 += j23;
                                                        }
                                                        j21 = j14;
                                                        eVar2 = eVar;
                                                        z18 = z11;
                                                        str6 = str9;
                                                        obj2 = obj;
                                                        str4 = str3;
                                                        j24 = j22;
                                                        i13 = i11;
                                                        bVar2 = bVar;
                                                        arrayList6 = arrayList2;
                                                        j23 = -1;
                                                        j26 = 0;
                                                        str7 = str2;
                                                        j25 = j15;
                                                        dVar2 = dVar;
                                                        z13 = z18;
                                                    }
                                                }
                                            } else if (bVar2 == null && "PART".equals(y(b11, N, hashMap))) {
                                                String y14 = y(b11, K, hashMap);
                                                long s11 = s(b11, F, -1L);
                                                long s12 = s(b11, G, -1L);
                                                long j32 = j25;
                                                String d13 = d(j32, str5, str9);
                                                if (obj2 == null && !treeMap.isEmpty()) {
                                                    DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData4 = new DrmInitData(str2, schemeDataArr3);
                                                    if (drmInitData == null) {
                                                        drmInitData = c(str2, schemeDataArr3);
                                                    }
                                                    obj2 = drmInitData4;
                                                }
                                                if (s11 == -1 || s12 != -1) {
                                                    bVar2 = new d.b(y14, c0374d, 0L, i15, j22, obj2, str5, d13, s11 != -1 ? s11 : 0L, s12, false, false, true);
                                                }
                                                eVar2 = eVar;
                                                dVar2 = dVar;
                                                j25 = j32;
                                                str6 = str9;
                                                arrayList7 = arrayList10;
                                                i13 = i11;
                                                arrayList6 = arrayList2;
                                                str7 = str2;
                                            }
                                        }
                                        arrayList = arrayList10;
                                        j11 = j25;
                                        z10 = false;
                                    }
                                    eVar2 = eVar;
                                    dVar2 = dVar;
                                    str7 = str16;
                                    str6 = str9;
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList2;
                            }
                        }
                        bVar = bVar2;
                        eVar2 = eVar;
                        str6 = str9;
                        i13 = i11;
                        bVar2 = bVar;
                        j25 = j11;
                        str7 = str2;
                        arrayList7 = arrayList;
                        arrayList6 = arrayList2;
                        z13 = z10;
                        dVar2 = dVar;
                    }
                    z13 = false;
                }
                str6 = str9;
                z13 = false;
            }
        }
        int i21 = i13;
        d.b bVar4 = bVar2;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        int i22 = z13 ? 1 : 0;
        HashMap hashMap3 = new HashMap();
        for (int i23 = i22; i23 < arrayList5.size(); i23++) {
            d.c cVar = (d.c) arrayList5.get(i23);
            long j33 = cVar.f26199b;
            if (j33 == -1) {
                j33 = (j18 + arrayList3.size()) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int i24 = cVar.f26200c;
            if (i24 == -1 && j20 != C.TIME_UNSET) {
                i24 = (arrayList11.isEmpty() ? ((d.C0374d) g3.g(arrayList3)).f26202m : arrayList11).size() - 1;
            }
            Uri uri = cVar.f26198a;
            hashMap3.put(uri, new d.c(uri, j33, i24));
        }
        if (bVar4 != null) {
            arrayList11.add(bVar4);
        }
        return new d(i21, str, arrayList12, j16, z15, j17, z16, i14, j18, i16, j19, j20, z14, z17, j17 != 0, drmInitData, arrayList3, arrayList11, fVar2, hashMap3);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:84:0x0343. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    private static e o(a aVar, String str) {
        char c11;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        ArrayList arrayList3;
        int parseInt;
        String str3;
        int i11;
        String str4;
        int i12;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        int i13;
        int i14;
        ArrayList arrayList9;
        ArrayList arrayList10;
        Uri e11;
        HashMap hashMap;
        String str5 = str;
        int i15 = 1;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        int i16 = 0;
        boolean z10 = false;
        while (true) {
            boolean a11 = aVar.a();
            String str6 = MimeTypes.APPLICATION_M3U8;
            if (!a11) {
                HashMap hashMap4 = hashMap2;
                ArrayList arrayList19 = arrayList12;
                ArrayList arrayList20 = arrayList13;
                ArrayList arrayList21 = arrayList14;
                ArrayList arrayList22 = arrayList15;
                ArrayList arrayList23 = arrayList16;
                ArrayList arrayList24 = arrayList17;
                ArrayList arrayList25 = arrayList18;
                ArrayList arrayList26 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i17 = 0;
                while (i17 < arrayList11.size()) {
                    e.b bVar = (e.b) arrayList11.get(i17);
                    if (hashSet.add(bVar.f26234a)) {
                        com.google.android.exoplayer2.util.a.g(bVar.f26235b.f25548j == null);
                        i12 = 1;
                        arrayList26.add(bVar.a(bVar.f26235b.b().X(new Metadata(new HlsTrackMetadataEntry(null, null, (List) com.google.android.exoplayer2.util.a.e((ArrayList) hashMap4.get(bVar.f26234a))))).E()));
                    } else {
                        i12 = 1;
                    }
                    i17 += i12;
                }
                Uri uri = null;
                ArrayList arrayList27 = null;
                o1 o1Var = null;
                int i18 = 0;
                while (i18 < arrayList23.size()) {
                    ArrayList arrayList28 = arrayList23;
                    String str7 = (String) arrayList28.get(i18);
                    String y10 = y(str7, Q, hashMap3);
                    String y11 = y(str7, P, hashMap3);
                    o1.b bVar2 = new o1.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(y10).length() + 1 + String.valueOf(y11).length());
                    sb2.append(y10);
                    sb2.append(":");
                    sb2.append(y11);
                    o1.b V2 = bVar2.S(sb2.toString()).U(y11).K(str6).g0(w(str7)).c0(v(str7, hashMap3)).V(u(str7, O, hashMap3));
                    String u11 = u(str7, K, hashMap3);
                    Uri e12 = u11 == null ? uri : n0.e(str, u11);
                    String str8 = str6;
                    arrayList23 = arrayList28;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(y10, y11, Collections.emptyList()));
                    String y12 = y(str7, M, hashMap3);
                    y12.hashCode();
                    switch (y12.hashCode()) {
                        case -959297733:
                            if (y12.equals("SUBTITLES")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -333210994:
                            if (y12.equals("CLOSED-CAPTIONS")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case 62628790:
                            if (y12.equals("AUDIO")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 81665115:
                            if (y12.equals("VIDEO")) {
                                c11 = 3;
                                break;
                            }
                            break;
                    }
                    c11 = 65535;
                    switch (c11) {
                        case 0:
                            arrayList = arrayList20;
                            arrayList2 = arrayList19;
                            e.b f11 = f(arrayList11, y10);
                            if (f11 != null) {
                                String L2 = p0.L(f11.f26235b.f25547i, 3);
                                V2.I(L2);
                                str2 = w.g(L2);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = MimeTypes.TEXT_VTT;
                            }
                            V2.e0(str2).X(metadata);
                            if (e12 != null) {
                                e.a aVar2 = new e.a(e12, V2.E(), y10, y11);
                                arrayList3 = arrayList21;
                                arrayList3.add(aVar2);
                            } else {
                                arrayList3 = arrayList21;
                                s.i("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                            }
                            i11 = 1;
                            break;
                        case 1:
                            arrayList = arrayList20;
                            arrayList2 = arrayList19;
                            String y13 = y(str7, S, hashMap3);
                            if (y13.startsWith("CC")) {
                                parseInt = Integer.parseInt(y13.substring(2));
                                str3 = MimeTypes.APPLICATION_CEA608;
                            } else {
                                parseInt = Integer.parseInt(y13.substring(7));
                                str3 = MimeTypes.APPLICATION_CEA708;
                            }
                            if (arrayList27 == null) {
                                arrayList27 = new ArrayList();
                            }
                            V2.e0(str3).F(parseInt);
                            arrayList27.add(V2.E());
                            arrayList3 = arrayList21;
                            i11 = 1;
                            break;
                        case 2:
                            arrayList2 = arrayList19;
                            e.b e13 = e(arrayList11, y10);
                            if (e13 != null) {
                                String L3 = p0.L(e13.f26235b.f25547i, 1);
                                V2.I(L3);
                                str4 = w.g(L3);
                            } else {
                                str4 = null;
                            }
                            String u12 = u(str7, f26124i, hashMap3);
                            if (u12 != null) {
                                V2.H(Integer.parseInt(p0.T0(u12, "/")[0]));
                                if (MimeTypes.AUDIO_E_AC3.equals(str4) && u12.endsWith("/JOC")) {
                                    V2.I("ec+3");
                                    str4 = MimeTypes.AUDIO_E_AC3_JOC;
                                }
                            }
                            V2.e0(str4);
                            if (e12 == null) {
                                arrayList = arrayList20;
                                if (e13 != null) {
                                    o1Var = V2.E();
                                    arrayList3 = arrayList21;
                                    i11 = 1;
                                    break;
                                }
                            } else {
                                V2.X(metadata);
                                arrayList = arrayList20;
                                arrayList.add(new e.a(e12, V2.E(), y10, y11));
                            }
                            arrayList3 = arrayList21;
                            i11 = 1;
                            break;
                        case 3:
                            e.b g11 = g(arrayList11, y10);
                            if (g11 != null) {
                                o1 o1Var2 = g11.f26235b;
                                String L4 = p0.L(o1Var2.f25547i, 2);
                                V2.I(L4).e0(w.g(L4)).j0(o1Var2.f25555q).Q(o1Var2.f25556r).P(o1Var2.f25557s);
                            }
                            if (e12 != null) {
                                V2.X(metadata);
                                arrayList2 = arrayList19;
                                arrayList2.add(new e.a(e12, V2.E(), y10, y11));
                                arrayList3 = arrayList21;
                                arrayList = arrayList20;
                                i11 = 1;
                                break;
                            }
                        default:
                            arrayList3 = arrayList21;
                            arrayList = arrayList20;
                            arrayList2 = arrayList19;
                            i11 = 1;
                            break;
                    }
                    i18 += i11;
                    arrayList19 = arrayList2;
                    arrayList21 = arrayList3;
                    arrayList20 = arrayList;
                    str6 = str8;
                    uri = null;
                }
                return new e(str, arrayList25, arrayList26, arrayList19, arrayList20, arrayList21, arrayList22, o1Var, z10 ? Collections.emptyList() : arrayList27, i16, hashMap3, arrayList24);
            }
            String b11 = aVar.b();
            if (b11.startsWith("#EXT")) {
                arrayList18.add(b11);
            }
            boolean startsWith = b11.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            if (b11.startsWith("#EXT-X-DEFINE")) {
                hashMap3.put(y(b11, P, hashMap3), y(b11, Z, hashMap3));
            } else if (b11.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                i16 = i15;
            } else if (b11.startsWith("#EXT-X-MEDIA")) {
                arrayList16.add(b11);
            } else if (b11.startsWith("#EXT-X-SESSION-KEY")) {
                DrmInitData.SchemeData j11 = j(b11, t(b11, I, "identity", hashMap3), hashMap3);
                if (j11 != null) {
                    String k11 = k(y(b11, H, hashMap3));
                    DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[i15];
                    schemeDataArr[0] = j11;
                    arrayList17.add(new DrmInitData(k11, schemeDataArr));
                }
            } else if (b11.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                z10 |= b11.contains("CLOSED-CAPTIONS=NONE");
                int i19 = startsWith ? 16384 : 0;
                int l11 = l(b11, f26123h);
                arrayList4 = arrayList17;
                arrayList5 = arrayList15;
                int r11 = r(b11, f26118c, -1);
                String u13 = u(b11, f26125j, hashMap3);
                arrayList6 = arrayList18;
                String u14 = u(b11, f26126k, hashMap3);
                if (u14 != null) {
                    arrayList7 = arrayList14;
                    String[] S0 = p0.S0(u14, "x");
                    i14 = Integer.parseInt(S0[0]);
                    i13 = Integer.parseInt(S0[1]);
                    if (i14 <= 0 || i13 <= 0) {
                        i13 = -1;
                        i14 = -1;
                    }
                    arrayList8 = arrayList13;
                } else {
                    arrayList7 = arrayList14;
                    arrayList8 = arrayList13;
                    i13 = -1;
                    i14 = -1;
                }
                String u15 = u(b11, f26127l, hashMap3);
                float parseFloat = u15 != null ? Float.parseFloat(u15) : -1.0f;
                arrayList9 = arrayList12;
                String u16 = u(b11, f26119d, hashMap3);
                arrayList10 = arrayList16;
                String u17 = u(b11, f26120e, hashMap3);
                HashMap hashMap5 = hashMap2;
                String u18 = u(b11, f26121f, hashMap3);
                String u19 = u(b11, f26122g, hashMap3);
                if (startsWith) {
                    e11 = n0.e(str5, y(b11, K, hashMap3));
                } else {
                    if (!aVar.a()) {
                        throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                    }
                    e11 = n0.e(str5, A(aVar.b(), hashMap3));
                }
                arrayList11.add(new e.b(e11, new o1.b().R(arrayList11.size()).K(MimeTypes.APPLICATION_M3U8).I(u13).G(r11).Z(l11).j0(i14).Q(i13).P(parseFloat).c0(i19).E(), u16, u17, u18, u19));
                hashMap = hashMap5;
                ArrayList arrayList29 = (ArrayList) hashMap.get(e11);
                if (arrayList29 == null) {
                    arrayList29 = new ArrayList();
                    hashMap.put(e11, arrayList29);
                }
                arrayList29.add(new HlsTrackMetadataEntry.VariantInfo(r11, l11, u16, u17, u18, u19));
                hashMap2 = hashMap;
                arrayList17 = arrayList4;
                arrayList15 = arrayList5;
                arrayList18 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
                i15 = 1;
                str5 = str;
            }
            hashMap = hashMap2;
            arrayList9 = arrayList12;
            arrayList8 = arrayList13;
            arrayList7 = arrayList14;
            arrayList5 = arrayList15;
            arrayList10 = arrayList16;
            arrayList4 = arrayList17;
            arrayList6 = arrayList18;
            hashMap2 = hashMap;
            arrayList17 = arrayList4;
            arrayList15 = arrayList5;
            arrayList18 = arrayList6;
            arrayList14 = arrayList7;
            arrayList13 = arrayList8;
            arrayList12 = arrayList9;
            arrayList16 = arrayList10;
            i15 = 1;
            str5 = str;
        }
    }

    private static boolean p(String str, Pattern pattern, boolean z10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z10;
    }

    private static double q(String str, Pattern pattern, double d11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : d11;
    }

    private static int r(String str, Pattern pattern, int i11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : i11;
    }

    private static long s(String str, Pattern pattern, long j11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))) : j11;
    }

    private static String t(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : A(str2, map);
    }

    private static String u(String str, Pattern pattern, Map map) {
        return t(str, pattern, null, map);
    }

    private static int v(String str, Map map) {
        String u11 = u(str, R, map);
        if (TextUtils.isEmpty(u11)) {
            return 0;
        }
        String[] S0 = p0.S0(u11, ",");
        int i11 = p0.s(S0, "public.accessibility.describes-video") ? 512 : 0;
        if (p0.s(S0, "public.accessibility.transcribes-spoken-dialog")) {
            i11 |= 4096;
        }
        if (p0.s(S0, "public.accessibility.describes-music-and-sound")) {
            i11 |= 1024;
        }
        return p0.s(S0, "public.easy-to-read") ? i11 | 8192 : i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int w(String str) {
        boolean p11 = p(str, U, false);
        ?? r02 = p11;
        if (p(str, V, false)) {
            r02 = (p11 ? 1 : 0) | 2;
        }
        return p(str, T, false) ? r02 | 4 : r02;
    }

    private static d.f x(String str) {
        double q11 = q(str, f26133r, -9.223372036854776E18d);
        long j11 = C.TIME_UNSET;
        long j12 = q11 == -9.223372036854776E18d ? -9223372036854775807L : (long) (q11 * 1000000.0d);
        boolean p11 = p(str, f26134s, false);
        double q12 = q(str, f26136u, -9.223372036854776E18d);
        long j13 = q12 == -9.223372036854776E18d ? -9223372036854775807L : (long) (q12 * 1000000.0d);
        double q13 = q(str, f26137v, -9.223372036854776E18d);
        if (q13 != -9.223372036854776E18d) {
            j11 = (long) (q13 * 1000000.0d);
        }
        return new d.f(j12, p11, j13, j11, p(str, f26138w, false));
    }

    private static String y(String str, Pattern pattern, Map map) {
        String u11 = u(str, pattern, map);
        if (u11 != null) {
            return u11;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb2 = new StringBuilder(String.valueOf(pattern2).length() + 19 + String.valueOf(str).length());
        sb2.append("Couldn't match ");
        sb2.append(pattern2);
        sb2.append(" in ");
        sb2.append(str);
        throw ParserException.createForMalformedManifest(sb2.toString(), null);
    }

    private static long z(String str, Pattern pattern) {
        return new BigDecimal(y(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    @Override // com.google.android.exoplayer2.upstream.b0.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public y9.d parse(Uri uri, InputStream inputStream) {
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
                    p0.n(bufferedReader);
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
                        return o(new a(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(trim);
            return n(this.f26142a, this.f26143b, new a(arrayDeque, bufferedReader), uri.toString());
        } finally {
            p0.n(bufferedReader);
        }
    }
}
