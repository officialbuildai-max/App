package t2;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.b1;
import androidx.media3.common.util.u;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import t2.c;

/* loaded from: classes2.dex */
abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f76135a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f76136b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f76137c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static c a(String str) {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            u.h("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static c b(String str) {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (!b1.f(newPullParser, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
        }
        ImmutableList of2 = ImmutableList.of();
        long j11 = C.TIME_UNSET;
        do {
            newPullParser.next();
            if (b1.f(newPullParser, "rdf:Description")) {
                if (!d(newPullParser)) {
                    return null;
                }
                j11 = e(newPullParser);
                of2 = c(newPullParser);
            } else if (b1.f(newPullParser, "Container:Directory")) {
                of2 = f(newPullParser, "Container", "Item");
            } else if (b1.f(newPullParser, "GContainer:Directory")) {
                of2 = f(newPullParser, "GContainer", "GContainerItem");
            }
        } while (!b1.d(newPullParser, "x:xmpmeta"));
        if (of2.isEmpty()) {
            return null;
        }
        return new c(j11, of2);
    }

    private static ImmutableList c(XmlPullParser xmlPullParser) {
        for (String str : f76137c) {
            String a11 = b1.a(xmlPullParser, str);
            if (a11 != null) {
                return ImmutableList.of(new c.a("image/jpeg", "Primary", 0L, 0L), new c.a(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(a11), 0L));
            }
        }
        return ImmutableList.of();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f76135a) {
            String a11 = b1.a(xmlPullParser, str);
            if (a11 != null) {
                return Integer.parseInt(a11) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String str : f76136b) {
            String a11 = b1.a(xmlPullParser, str);
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
            if (b1.f(xmlPullParser, str3)) {
                String a11 = b1.a(xmlPullParser, str2 + ":Mime");
                String a12 = b1.a(xmlPullParser, str2 + ":Semantic");
                String a13 = b1.a(xmlPullParser, str2 + ":Length");
                String a14 = b1.a(xmlPullParser, str2 + ":Padding");
                if (a11 == null || a12 == null) {
                    return ImmutableList.of();
                }
                builder.a(new c.a(a11, a12, a13 != null ? Long.parseLong(a13) : 0L, a14 != null ? Long.parseLong(a14) : 0L));
            }
        } while (!b1.d(xmlPullParser, str4));
        return builder.e();
    }
}
