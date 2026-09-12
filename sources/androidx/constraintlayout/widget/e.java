package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    int f7939a = -1;

    /* renamed from: b, reason: collision with root package name */
    int f7940b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f7941c = -1;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray f7942d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    private SparseArray f7943e = new SparseArray();

    /* renamed from: f, reason: collision with root package name */
    private c f7944f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f7945a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f7946b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        int f7947c;

        /* renamed from: d, reason: collision with root package name */
        boolean f7948d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f7947c = -1;
            this.f7948d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.State_android_id) {
                    this.f7945a = obtainStyledAttributes.getResourceId(index, this.f7945a);
                } else if (index == R$styleable.State_constraints) {
                    this.f7947c = obtainStyledAttributes.getResourceId(index, this.f7947c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7947c);
                    context.getResources().getResourceName(this.f7947c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f7948d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f7946b.add(bVar);
        }

        public int b(float f11, float f12) {
            for (int i11 = 0; i11 < this.f7946b.size(); i11++) {
                if (((b) this.f7946b.get(i11)).a(f11, f12)) {
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
        float f7949a;

        /* renamed from: b, reason: collision with root package name */
        float f7950b;

        /* renamed from: c, reason: collision with root package name */
        float f7951c;

        /* renamed from: d, reason: collision with root package name */
        float f7952d;

        /* renamed from: e, reason: collision with root package name */
        int f7953e;

        /* renamed from: f, reason: collision with root package name */
        boolean f7954f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f7949a = Float.NaN;
            this.f7950b = Float.NaN;
            this.f7951c = Float.NaN;
            this.f7952d = Float.NaN;
            this.f7953e = -1;
            this.f7954f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Variant_constraints) {
                    this.f7953e = obtainStyledAttributes.getResourceId(index, this.f7953e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7953e);
                    context.getResources().getResourceName(this.f7953e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f7954f = true;
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f7952d = obtainStyledAttributes.getDimension(index, this.f7952d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f7950b = obtainStyledAttributes.getDimension(index, this.f7950b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f7951c = obtainStyledAttributes.getDimension(index, this.f7951c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f7949a = obtainStyledAttributes.getDimension(index, this.f7949a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f7949a) && f11 < this.f7949a) {
                return false;
            }
            if (!Float.isNaN(this.f7950b) && f12 < this.f7950b) {
                return false;
            }
            if (Float.isNaN(this.f7951c) || f11 <= this.f7951c) {
                return Float.isNaN(this.f7952d) || f12 <= this.f7952d;
            }
            return false;
        }
    }

    public e(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.StateSet_defaultState) {
                this.f7939a = obtainStyledAttributes.getResourceId(index, this.f7939a);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (true) {
                char c11 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
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
                        aVar = new a(context, xmlPullParser);
                        this.f7942d.put(aVar.f7945a, aVar);
                    } else if (c11 == 3) {
                        b bVar = new b(context, xmlPullParser);
                        if (aVar != null) {
                            aVar.a(bVar);
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    public int a(int i11, int i12, float f11, float f12) {
        a aVar = (a) this.f7942d.get(i12);
        if (aVar == null) {
            return i12;
        }
        if (f11 == -1.0f || f12 == -1.0f) {
            if (aVar.f7947c == i11) {
                return i11;
            }
            Iterator it = aVar.f7946b.iterator();
            while (it.hasNext()) {
                if (i11 == ((b) it.next()).f7953e) {
                    return i11;
                }
            }
            return aVar.f7947c;
        }
        Iterator it2 = aVar.f7946b.iterator();
        b bVar = null;
        while (it2.hasNext()) {
            b bVar2 = (b) it2.next();
            if (bVar2.a(f11, f12)) {
                if (i11 == bVar2.f7953e) {
                    return i11;
                }
                bVar = bVar2;
            }
        }
        return bVar != null ? bVar.f7953e : aVar.f7947c;
    }

    public int c(int i11, int i12, int i13) {
        return d(-1, i11, i12, i13);
    }

    public int d(int i11, int i12, float f11, float f12) {
        int b11;
        if (i11 == i12) {
            a aVar = i12 == -1 ? (a) this.f7942d.valueAt(0) : (a) this.f7942d.get(this.f7940b);
            if (aVar == null) {
                return -1;
            }
            return ((this.f7941c == -1 || !((b) aVar.f7946b.get(i11)).a(f11, f12)) && i11 != (b11 = aVar.b(f11, f12))) ? b11 == -1 ? aVar.f7947c : ((b) aVar.f7946b.get(b11)).f7953e : i11;
        }
        a aVar2 = (a) this.f7942d.get(i12);
        if (aVar2 == null) {
            return -1;
        }
        int b12 = aVar2.b(f11, f12);
        return b12 == -1 ? aVar2.f7947c : ((b) aVar2.f7946b.get(b12)).f7953e;
    }
}
