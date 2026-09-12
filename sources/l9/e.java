package l9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q0;
import com.google.android.exoplayer2.util.s;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.StringReader;
import l9.b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes4.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f68898a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f68899b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f68900c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static b a(String str) {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            s.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static b b(String str) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (!q0.f(newPullParser, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
        }
        ImmutableList of2 = ImmutableList.of();
        long j11 = C.TIME_UNSET;
        do {
            newPullParser.next();
            if (q0.f(newPullParser, "rdf:Description")) {
                if (!d(newPullParser)) {
                    return null;
                }
                j11 = e(newPullParser);
                of2 = c(newPullParser);
            } else if (q0.f(newPullParser, "Container:Directory")) {
                of2 = f(newPullParser, "Container", "Item");
            } else if (q0.f(newPullParser, "GContainer:Directory")) {
                of2 = f(newPullParser, "GContainer", "GContainerItem");
            }
        } while (!q0.d(newPullParser, "x:xmpmeta"));
        if (of2.isEmpty()) {
            return null;
        }
        return new b(j11, of2);
    }

    private static ImmutableList c(XmlPullParser xmlPullParser) {
        for (String str : f68900c) {
            String a11 = q0.a(xmlPullParser, str);
            if (a11 != null) {
                return ImmutableList.of(new b.a("image/jpeg", "Primary", 0L, 0L), new b.a(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(a11), 0L));
            }
        }
        return ImmutableList.of();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f68898a) {
            String a11 = q0.a(xmlPullParser, str);
            if (a11 != null) {
                return Integer.parseInt(a11) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String str : f68899b) {
            String a11 = q0.a(xmlPullParser, str);
            if (a11 != null) {
                long parseLong = Long.parseLong(a11);
                return parseLong == -1 ? C.TIME_UNSET : parseLong;
            }
        }
        return C.TIME_UNSET;
    }

    private static ImmutableList f(XmlPullParser xmlPullParser, String str, String str2) {
        ImmutableList.a builder = ImmutableList.builder();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, str3)) {
                String a11 = q0.a(xmlPullParser, str2 + ":Mime");
                String a12 = q0.a(xmlPullParser, str2 + ":Semantic");
                String a13 = q0.a(xmlPullParser, str2 + ":Length");
                String a14 = q0.a(xmlPullParser, str2 + ":Padding");
                if (a11 == null || a12 == null) {
                    return ImmutableList.of();
                }
                builder.a(new b.a(a11, a12, a13 != null ? Long.parseLong(a13) : 0L, a14 != null ? Long.parseLong(a14) : 0L));
            }
        } while (!q0.d(xmlPullParser, str4));
        return builder.e();
    }
}
