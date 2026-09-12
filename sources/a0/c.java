package a0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.k1;
import androidx.compose.ui.graphics.q4;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.vector.c;
import androidx.compose.ui.graphics.vector.g;
import androidx.compose.ui.graphics.vector.k;
import androidx.compose.ui.graphics.w1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import o0.i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import y0.d;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f107a = 0;

    public static final c.a a(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        long e11;
        int z10;
        b bVar = b.f81a;
        TypedArray k11 = aVar.k(resources, theme, attributeSet, bVar.F());
        boolean d11 = aVar.d(k11, "autoMirrored", bVar.a(), false);
        float g11 = aVar.g(k11, "viewportWidth", bVar.H(), 0.0f);
        float g12 = aVar.g(k11, "viewportHeight", bVar.G(), 0.0f);
        if (g11 <= 0.0f) {
            throw new XmlPullParserException(k11.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        }
        if (g12 <= 0.0f) {
            throw new XmlPullParserException(k11.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
        float a11 = aVar.a(k11, bVar.I(), 0.0f);
        float a12 = aVar.a(k11, bVar.n(), 0.0f);
        if (k11.hasValue(bVar.D())) {
            TypedValue typedValue = new TypedValue();
            k11.getValue(bVar.D(), typedValue);
            if (typedValue.type == 2) {
                e11 = u1.f4733b.e();
            } else {
                ColorStateList e12 = aVar.e(k11, theme, "tint", bVar.D());
                e11 = e12 != null ? w1.b(e12.getDefaultColor()) : u1.f4733b.e();
            }
        } else {
            e11 = u1.f4733b.e();
        }
        long j11 = e11;
        int c11 = aVar.c(k11, bVar.E(), -1);
        if (c11 == -1) {
            z10 = c1.f4367a.z();
        } else if (c11 == 3) {
            z10 = c1.f4367a.B();
        } else if (c11 == 5) {
            z10 = c1.f4367a.z();
        } else if (c11 != 9) {
            switch (c11) {
                case 14:
                    z10 = c1.f4367a.q();
                    break;
                case 15:
                    z10 = c1.f4367a.v();
                    break;
                case 16:
                    z10 = c1.f4367a.t();
                    break;
                default:
                    z10 = c1.f4367a.z();
                    break;
            }
        } else {
            z10 = c1.f4367a.y();
        }
        int i11 = z10;
        float g13 = i.g(a11 / resources.getDisplayMetrics().density);
        float g14 = i.g(a12 / resources.getDisplayMetrics().density);
        k11.recycle();
        return new c.a(null, g13, g14, g11, g12, j11, i11, d11, 1, null);
    }

    private static final int b(int i11, int i12) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i12 : c5.f4393a.c() : c5.f4393a.b() : c5.f4393a.a();
    }

    private static final int c(int i11, int i12) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i12 : d5.f4505a.a() : d5.f4505a.c() : d5.f4505a.b();
    }

    public static final boolean d(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() != 1) {
            return xmlPullParser.getDepth() < 1 && xmlPullParser.getEventType() == 3;
        }
        return true;
    }

    private static final j1 e(d dVar) {
        if (!dVar.l()) {
            return null;
        }
        Shader f11 = dVar.f();
        return f11 != null ? k1.a(f11) : new b5(w1.b(dVar.e()), null);
    }

    public static final void f(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet, c.a aVar2) {
        b bVar = b.f81a;
        TypedArray k11 = aVar.k(resources, theme, attributeSet, bVar.b());
        String i11 = aVar.i(k11, bVar.c());
        if (i11 == null) {
            i11 = "";
        }
        String str = i11;
        String i12 = aVar.i(k11, bVar.d());
        List d11 = i12 == null ? k.d() : g.b(aVar.f80c, i12, null, 2, null);
        k11.recycle();
        aVar2.a((r20 & 1) != 0 ? "" : str, (r20 & 2) != 0 ? 0.0f : 0.0f, (r20 & 4) != 0 ? 0.0f : 0.0f, (r20 & 8) != 0 ? 0.0f : 0.0f, (r20 & 16) != 0 ? 1.0f : 0.0f, (r20 & 32) == 0 ? 0.0f : 1.0f, (r20 & 64) != 0 ? 0.0f : 0.0f, (r20 & 128) == 0 ? 0.0f : 0.0f, (r20 & 256) != 0 ? k.d() : d11);
    }

    public static final int g(a aVar, Resources resources, AttributeSet attributeSet, Resources.Theme theme, c.a aVar2, int i11) {
        int eventType = aVar.j().getEventType();
        if (eventType != 2) {
            if (eventType != 3 || !Intrinsics.c("group", aVar.j().getName())) {
                return i11;
            }
            int i12 = i11 + 1;
            for (int i13 = 0; i13 < i12; i13++) {
                aVar2.f();
            }
            return 0;
        }
        String name = aVar.j().getName();
        if (name == null) {
            return i11;
        }
        int hashCode = name.hashCode();
        if (hashCode == -1649314686) {
            if (!name.equals("clip-path")) {
                return i11;
            }
            f(aVar, resources, theme, attributeSet, aVar2);
            return i11 + 1;
        }
        if (hashCode == 3433509) {
            if (!name.equals("path")) {
                return i11;
            }
            i(aVar, resources, theme, attributeSet, aVar2);
            return i11;
        }
        if (hashCode != 98629247 || !name.equals("group")) {
            return i11;
        }
        h(aVar, resources, theme, attributeSet, aVar2);
        return i11;
    }

    public static final void h(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet, c.a aVar2) {
        b bVar = b.f81a;
        TypedArray k11 = aVar.k(resources, theme, attributeSet, bVar.e());
        float g11 = aVar.g(k11, "rotation", bVar.i(), 0.0f);
        float b11 = aVar.b(k11, bVar.g(), 0.0f);
        float b12 = aVar.b(k11, bVar.h(), 0.0f);
        float g12 = aVar.g(k11, "scaleX", bVar.j(), 1.0f);
        float g13 = aVar.g(k11, "scaleY", bVar.k(), 1.0f);
        float g14 = aVar.g(k11, "translateX", bVar.l(), 0.0f);
        float g15 = aVar.g(k11, "translateY", bVar.m(), 0.0f);
        String i11 = aVar.i(k11, bVar.f());
        if (i11 == null) {
            i11 = "";
        }
        k11.recycle();
        aVar2.a(i11, g11, b11, b12, g12, g13, g14, g15, k.d());
    }

    public static final void i(a aVar, Resources resources, Resources.Theme theme, AttributeSet attributeSet, c.a aVar2) {
        b bVar = b.f81a;
        TypedArray k11 = aVar.k(resources, theme, attributeSet, bVar.o());
        if (!y0.k.j(aVar.j(), "pathData")) {
            throw new IllegalArgumentException("No path data available");
        }
        String i11 = aVar.i(k11, bVar.r());
        if (i11 == null) {
            i11 = "";
        }
        String str = i11;
        String i12 = aVar.i(k11, bVar.s());
        List d11 = i12 == null ? k.d() : g.b(aVar.f80c, i12, null, 2, null);
        d f11 = aVar.f(k11, theme, "fillColor", bVar.q(), 0);
        float g11 = aVar.g(k11, "fillAlpha", bVar.p(), 1.0f);
        int b11 = b(aVar.h(k11, "strokeLineCap", bVar.v(), -1), c5.f4393a.a());
        int c11 = c(aVar.h(k11, "strokeLineJoin", bVar.w(), -1), d5.f4505a.a());
        float g12 = aVar.g(k11, "strokeMiterLimit", bVar.x(), 1.0f);
        d f12 = aVar.f(k11, theme, "strokeColor", bVar.u(), 0);
        float g13 = aVar.g(k11, "strokeAlpha", bVar.t(), 1.0f);
        float g14 = aVar.g(k11, "strokeWidth", bVar.y(), 1.0f);
        float g15 = aVar.g(k11, "trimPathEnd", bVar.z(), 1.0f);
        float g16 = aVar.g(k11, "trimPathOffset", bVar.B(), 0.0f);
        float g17 = aVar.g(k11, "trimPathStart", bVar.C(), 0.0f);
        int h11 = aVar.h(k11, "fillType", bVar.A(), f107a);
        k11.recycle();
        j1 e11 = e(f11);
        j1 e12 = e(f12);
        q4.a aVar3 = q4.f4703a;
        aVar2.c(d11, h11 == 0 ? aVar3.b() : aVar3.a(), str, e11, g11, e12, g13, g14, b11, c11, g12, g17, g15, g16);
    }

    public static final XmlPullParser j(XmlPullParser xmlPullParser) {
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }
}
