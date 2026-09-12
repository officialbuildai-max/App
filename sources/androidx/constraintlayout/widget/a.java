package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f7811a;

    /* renamed from: b, reason: collision with root package name */
    androidx.constraintlayout.widget.b f7812b;

    /* renamed from: c, reason: collision with root package name */
    int f7813c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f7814d = -1;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray f7815e = new SparseArray();

    /* renamed from: f, reason: collision with root package name */
    private SparseArray f7816f = new SparseArray();

    /* renamed from: g, reason: collision with root package name */
    private c f7817g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a {

        /* renamed from: a, reason: collision with root package name */
        int f7818a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f7819b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        int f7820c;

        /* renamed from: d, reason: collision with root package name */
        androidx.constraintlayout.widget.b f7821d;

        public C0062a(Context context, XmlPullParser xmlPullParser) {
            this.f7820c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.State_android_id) {
                    this.f7818a = obtainStyledAttributes.getResourceId(index, this.f7818a);
                } else if (index == R$styleable.State_constraints) {
                    this.f7820c = obtainStyledAttributes.getResourceId(index, this.f7820c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7820c);
                    context.getResources().getResourceName(this.f7820c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f7821d = bVar;
                        bVar.p(context, this.f7820c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f7819b.add(bVar);
        }

        public int b(float f11, float f12) {
            for (int i11 = 0; i11 < this.f7819b.size(); i11++) {
                if (((b) this.f7819b.get(i11)).a(f11, f12)) {
                    return i11;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        float f7822a;

        /* renamed from: b, reason: collision with root package name */
        float f7823b;

        /* renamed from: c, reason: collision with root package name */
        float f7824c;

        /* renamed from: d, reason: collision with root package name */
        float f7825d;

        /* renamed from: e, reason: collision with root package name */
        int f7826e;

        /* renamed from: f, reason: collision with root package name */
        androidx.constraintlayout.widget.b f7827f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f7822a = Float.NaN;
            this.f7823b = Float.NaN;
            this.f7824c = Float.NaN;
            this.f7825d = Float.NaN;
            this.f7826e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Variant_constraints) {
                    this.f7826e = obtainStyledAttributes.getResourceId(index, this.f7826e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7826e);
                    context.getResources().getResourceName(this.f7826e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f7827f = bVar;
                        bVar.p(context, this.f7826e);
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f7825d = obtainStyledAttributes.getDimension(index, this.f7825d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f7823b = obtainStyledAttributes.getDimension(index, this.f7823b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f7824c = obtainStyledAttributes.getDimension(index, this.f7824c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f7822a = obtainStyledAttributes.getDimension(index, this.f7822a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f7822a) && f11 < this.f7822a) {
                return false;
            }
            if (!Float.isNaN(this.f7823b) && f12 < this.f7823b) {
                return false;
            }
            if (Float.isNaN(this.f7824c) || f11 <= this.f7824c) {
                return Float.isNaN(this.f7825d) || f12 <= this.f7825d;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, ConstraintLayout constraintLayout, int i11) {
        this.f7811a = constraintLayout;
        a(context, i11);
    }

    private void a(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            int eventType = xml.getEventType();
            C0062a c0062a = null;
            while (true) {
                char c11 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c11 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c11 = 3;
                                break;
                            }
                            break;
                    }
                    c11 = 65535;
                    if (c11 == 2) {
                        c0062a = new C0062a(context, xml);
                        this.f7815e.put(c0062a.f7818a, c0062a);
                    } else if (c11 == 3) {
                        b bVar = new b(context, xml);
                        if (c0062a != null) {
                            c0062a.a(bVar);
                        }
                    } else if (c11 == 4) {
                        b(context, xml);
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                bVar.I(context, xmlPullParser);
                this.f7816f.put(identifier, bVar);
                return;
            }
        }
    }

    public void c(c cVar) {
        this.f7817g = cVar;
    }

    public void d(int i11, float f11, float f12) {
        int b11;
        int i12 = this.f7813c;
        if (i12 == i11) {
            C0062a c0062a = i11 == -1 ? (C0062a) this.f7815e.valueAt(0) : (C0062a) this.f7815e.get(i12);
            int i13 = this.f7814d;
            if ((i13 == -1 || !((b) c0062a.f7819b.get(i13)).a(f11, f12)) && this.f7814d != (b11 = c0062a.b(f11, f12))) {
                androidx.constraintlayout.widget.b bVar = b11 == -1 ? this.f7812b : ((b) c0062a.f7819b.get(b11)).f7827f;
                int i14 = b11 == -1 ? c0062a.f7820c : ((b) c0062a.f7819b.get(b11)).f7826e;
                if (bVar == null) {
                    return;
                }
                this.f7814d = b11;
                c cVar = this.f7817g;
                if (cVar != null) {
                    cVar.b(-1, i14);
                }
                bVar.i(this.f7811a);
                c cVar2 = this.f7817g;
                if (cVar2 != null) {
                    cVar2.a(-1, i14);
                    return;
                }
                return;
            }
            return;
        }
        this.f7813c = i11;
        C0062a c0062a2 = (C0062a) this.f7815e.get(i11);
        int b12 = c0062a2.b(f11, f12);
        androidx.constraintlayout.widget.b bVar2 = b12 == -1 ? c0062a2.f7821d : ((b) c0062a2.f7819b.get(b12)).f7827f;
        int i15 = b12 == -1 ? c0062a2.f7820c : ((b) c0062a2.f7819b.get(b12)).f7826e;
        if (bVar2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i11 + ", dim =" + f11 + ", " + f12);
            return;
        }
        this.f7814d = b12;
        c cVar3 = this.f7817g;
        if (cVar3 != null) {
            cVar3.b(i11, i15);
        }
        bVar2.i(this.f7811a);
        c cVar4 = this.f7817g;
        if (cVar4 != null) {
            cVar4.a(i11, i15);
        }
    }
}
