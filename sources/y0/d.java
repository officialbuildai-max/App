package y0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Shader f78632a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f78633b;

    /* renamed from: c, reason: collision with root package name */
    private int f78634c;

    private d(Shader shader, ColorStateList colorStateList, int i11) {
        this.f78632a = shader;
        this.f78633b = colorStateList;
        this.f78634c = i11;
    }

    private static d a(Resources resources, int i11, Resources.Theme theme) {
        int next;
        XmlResourceParser xml = resources.getXml(i11);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(f.b(resources, xml, asAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(int i11) {
        return new d(null, null, i11);
    }

    static d c(ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(Shader shader) {
        return new d(shader, null, 0);
    }

    public static d g(Resources resources, int i11, Resources.Theme theme) {
        try {
            return a(resources, i11, theme);
        } catch (Exception e11) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e11);
            return null;
        }
    }

    public int e() {
        return this.f78634c;
    }

    public Shader f() {
        return this.f78632a;
    }

    public boolean h() {
        return this.f78632a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f78632a == null && (colorStateList = this.f78633b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f78633b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f78634c) {
                this.f78634c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i11) {
        this.f78634c = i11;
    }

    public boolean l() {
        return h() || this.f78634c != 0;
    }
}
