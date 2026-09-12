package y0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R$styleable;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int[] f78647a;

        /* renamed from: b, reason: collision with root package name */
        final float[] f78648b;

        a(int i11, int i12) {
            this.f78647a = new int[]{i11, i12};
            this.f78648b = new float[]{0.0f, 1.0f};
        }

        a(int i11, int i12, int i13) {
            this.f78647a = new int[]{i11, i12, i13};
            this.f78648b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List list, List list2) {
            int size = list.size();
            this.f78647a = new int[size];
            this.f78648b = new float[size];
            for (int i11 = 0; i11 < size; i11++) {
                this.f78647a[i11] = ((Integer) list.get(i11)).intValue();
                this.f78648b[i11] = ((Float) list2.get(i11)).floatValue();
            }
        }
    }

    private static a a(a aVar, int i11, int i12, boolean z10, int i13) {
        return aVar != null ? aVar : z10 ? new a(i11, i13, i12) : new a(i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray k11 = k.k(resources, theme, attributeSet, R$styleable.GradientColor);
        float f11 = k.f(k11, xmlPullParser, "startX", R$styleable.GradientColor_android_startX, 0.0f);
        float f12 = k.f(k11, xmlPullParser, "startY", R$styleable.GradientColor_android_startY, 0.0f);
        float f13 = k.f(k11, xmlPullParser, "endX", R$styleable.GradientColor_android_endX, 0.0f);
        float f14 = k.f(k11, xmlPullParser, "endY", R$styleable.GradientColor_android_endY, 0.0f);
        float f15 = k.f(k11, xmlPullParser, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
        float f16 = k.f(k11, xmlPullParser, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
        int g11 = k.g(k11, xmlPullParser, NativeComponentConstants.KEY_COMPONENT_TYPE, R$styleable.GradientColor_android_type, 0);
        int b11 = k.b(k11, xmlPullParser, "startColor", R$styleable.GradientColor_android_startColor, 0);
        boolean j11 = k.j(xmlPullParser, "centerColor");
        int b12 = k.b(k11, xmlPullParser, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
        int b13 = k.b(k11, xmlPullParser, "endColor", R$styleable.GradientColor_android_endColor, 0);
        int g12 = k.g(k11, xmlPullParser, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
        float f17 = k.f(k11, xmlPullParser, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
        k11.recycle();
        a a11 = a(c(resources, xmlPullParser, attributeSet, theme), b11, b13, j11, b12);
        if (g11 != 1) {
            return g11 != 2 ? new LinearGradient(f11, f12, f13, f14, a11.f78647a, a11.f78648b, d(g12)) : new SweepGradient(f15, f16, a11.f78647a, a11.f78648b);
        }
        if (f17 > 0.0f) {
            return new RadialGradient(f15, f16, f17, a11.f78647a, a11.f78648b, d(g12));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static y0.f.a c(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L85
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L85
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R$styleable.GradientColorItem
            android.content.res.TypedArray r3 = y0.k.k(r8, r11, r10, r3)
            int r5 = androidx.core.R$styleable.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R$styleable.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = androidx.core.R$styleable.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R$styleable.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L85:
            int r8 = r4.size()
            if (r8 <= 0) goto L91
            y0.f$a r8 = new y0.f$a
            r8.<init>(r4, r2)
            return r8
        L91:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):y0.f$a");
    }

    private static Shader.TileMode d(int i11) {
        return i11 != 1 ? i11 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
