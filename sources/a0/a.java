package a0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.ui.graphics.vector.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import y0.d;
import y0.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final XmlPullParser f78a;

    /* renamed from: b, reason: collision with root package name */
    private int f79b;

    /* renamed from: c, reason: collision with root package name */
    public final g f80c;

    public a(XmlPullParser xmlPullParser, int i11) {
        this.f78a = xmlPullParser;
        this.f79b = i11;
        this.f80c = new g();
    }

    public /* synthetic */ a(XmlPullParser xmlPullParser, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(xmlPullParser, (i12 & 2) != 0 ? 0 : i11);
    }

    private final void l(int i11) {
        this.f79b = i11 | this.f79b;
    }

    public final float a(TypedArray typedArray, int i11, float f11) {
        float dimension = typedArray.getDimension(i11, f11);
        l(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final float b(TypedArray typedArray, int i11, float f11) {
        float f12 = typedArray.getFloat(i11, f11);
        l(typedArray.getChangingConfigurations());
        return f12;
    }

    public final int c(TypedArray typedArray, int i11, int i12) {
        int i13 = typedArray.getInt(i11, i12);
        l(typedArray.getChangingConfigurations());
        return i13;
    }

    public final boolean d(TypedArray typedArray, String str, int i11, boolean z10) {
        boolean a11 = k.a(typedArray, this.f78a, str, i11, z10);
        l(typedArray.getChangingConfigurations());
        return a11;
    }

    public final ColorStateList e(TypedArray typedArray, Resources.Theme theme, String str, int i11) {
        ColorStateList c11 = k.c(typedArray, this.f78a, theme, str, i11);
        l(typedArray.getChangingConfigurations());
        return c11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f78a, aVar.f78a) && this.f79b == aVar.f79b;
    }

    public final d f(TypedArray typedArray, Resources.Theme theme, String str, int i11, int i12) {
        d e11 = k.e(typedArray, this.f78a, theme, str, i11, i12);
        l(typedArray.getChangingConfigurations());
        return e11;
    }

    public final float g(TypedArray typedArray, String str, int i11, float f11) {
        float f12 = k.f(typedArray, this.f78a, str, i11, f11);
        l(typedArray.getChangingConfigurations());
        return f12;
    }

    public final int h(TypedArray typedArray, String str, int i11, int i12) {
        int g11 = k.g(typedArray, this.f78a, str, i11, i12);
        l(typedArray.getChangingConfigurations());
        return g11;
    }

    public int hashCode() {
        return (this.f78a.hashCode() * 31) + this.f79b;
    }

    public final String i(TypedArray typedArray, int i11) {
        String string = typedArray.getString(i11);
        l(typedArray.getChangingConfigurations());
        return string;
    }

    public final XmlPullParser j() {
        return this.f78a;
    }

    public final TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        TypedArray k11 = k.k(resources, theme, attributeSet, iArr);
        l(k11.getChangingConfigurations());
        return k11;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.f78a + ", config=" + this.f79b + ')';
    }
}
