package y0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R$styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        static int a(TypedArray typedArray, int i11) {
            return typedArray.getType(i11);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
    }

    /* loaded from: classes2.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final d[] f78635a;

        public c(d[] dVarArr) {
            this.f78635a = dVarArr;
        }

        public d[] a() {
            return this.f78635a;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f78636a;

        /* renamed from: b, reason: collision with root package name */
        private final int f78637b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f78638c;

        /* renamed from: d, reason: collision with root package name */
        private final String f78639d;

        /* renamed from: e, reason: collision with root package name */
        private final int f78640e;

        /* renamed from: f, reason: collision with root package name */
        private final int f78641f;

        public d(String str, int i11, boolean z10, String str2, int i12, int i13) {
            this.f78636a = str;
            this.f78637b = i11;
            this.f78638c = z10;
            this.f78639d = str2;
            this.f78640e = i12;
            this.f78641f = i13;
        }

        public String a() {
            return this.f78636a;
        }

        public int b() {
            return this.f78641f;
        }

        public int c() {
            return this.f78640e;
        }

        public String d() {
            return this.f78639d;
        }

        public int e() {
            return this.f78637b;
        }

        public boolean f() {
            return this.f78638c;
        }
    }

    /* renamed from: y0.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0993e implements b {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.core.provider.e f78642a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.provider.e f78643b;

        /* renamed from: c, reason: collision with root package name */
        private final int f78644c;

        /* renamed from: d, reason: collision with root package name */
        private final int f78645d;

        /* renamed from: e, reason: collision with root package name */
        private final String f78646e;

        public C0993e(androidx.core.provider.e eVar, androidx.core.provider.e eVar2, int i11, int i12, String str) {
            this.f78642a = eVar;
            this.f78643b = eVar2;
            this.f78645d = i11;
            this.f78644c = i12;
            this.f78646e = str;
        }

        public androidx.core.provider.e a() {
            return this.f78643b;
        }

        public int b() {
            return this.f78645d;
        }

        public androidx.core.provider.e c() {
            return this.f78642a;
        }

        public String d() {
            return this.f78646e;
        }

        public int e() {
            return this.f78644c;
        }
    }

    private static int a(TypedArray typedArray, int i11) {
        return a.a(typedArray, i11);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i11) {
        if (i11 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i11);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i12 = 0; i12 < obtainTypedArray.length(); i12++) {
                    int resourceId = obtainTypedArray.getResourceId(i12, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i11)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        String string4 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderFallbackQuery);
        int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string5 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            List c11 = c(resources, resourceId);
            return new C0993e(new androidx.core.provider.e(string, string2, string3, c11), string4 != null ? new androidx.core.provider.e(string, string2, string4, c11) : null, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i11 = obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontWeight) ? R$styleable.FontFamilyFont_fontWeight : R$styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z10 = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontStyle) ? R$styleable.FontFamilyFont_fontStyle : R$styleable.FontFamilyFont_android_fontStyle, 0);
        int i12 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_ttcIndex) ? R$styleable.FontFamilyFont_ttcIndex : R$styleable.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(R$styleable.FontFamilyFont_fontVariationSettings) ? R$styleable.FontFamilyFont_fontVariationSettings : R$styleable.FontFamilyFont_android_fontVariationSettings);
        int i13 = obtainAttributes.getInt(i12, 0);
        int i14 = obtainAttributes.hasValue(R$styleable.FontFamilyFont_font) ? R$styleable.FontFamilyFont_font : R$styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i14, 0);
        String string2 = obtainAttributes.getString(i14);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i11, z10, string, i13, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i11 = 1;
        while (i11 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i11++;
            } else if (next == 3) {
                i11--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
