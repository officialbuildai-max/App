package i0;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.compose.ui.graphics.vector.c;
import i0.d;

/* loaded from: classes2.dex */
public abstract class i {
    public static final d.a a(Resources.Theme theme, Resources resources, XmlResourceParser xmlResourceParser, int i11) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        a0.a aVar = new a0.a(xmlResourceParser, 0, 2, null);
        c.a a11 = a0.c.a(aVar, resources, theme, asAttributeSet);
        int i12 = 0;
        while (!a0.c.d(xmlResourceParser)) {
            i12 = a0.c.g(aVar, resources, asAttributeSet, theme, a11, i12);
            xmlResourceParser.next();
        }
        return new d.a(a11.e(), i11);
    }
}
