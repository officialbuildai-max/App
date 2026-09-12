package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    static HashMap f7369b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap f7370a = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        f7369b = hashMap;
        try {
            hashMap.put("KeyAttribute", e.class.getConstructor(null));
            f7369b.put("KeyPosition", h.class.getConstructor(null));
            f7369b.put("KeyCycle", f.class.getConstructor(null));
            f7369b.put("KeyTimeCycle", j.class.getConstructor(null));
            f7369b.put("KeyTrigger", k.class.getConstructor(null));
        } catch (NoSuchMethodException e11) {
            Log.e("KeyFrames", "unable to load", e11);
        }
    }

    public g() {
    }

    public g(Context context, XmlPullParser xmlPullParser) {
        Exception e11;
        d dVar;
        Constructor constructor;
        HashMap hashMap;
        HashMap hashMap2;
        try {
            int eventType = xmlPullParser.getEventType();
            d dVar2 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (f7369b.containsKey(name)) {
                        try {
                            constructor = (Constructor) f7369b.get(name);
                        } catch (Exception e12) {
                            d dVar3 = dVar2;
                            e11 = e12;
                            dVar = dVar3;
                        }
                        if (constructor == null) {
                            throw new NullPointerException("Keymaker for " + name + " not found");
                            break;
                        }
                        dVar = (d) constructor.newInstance(null);
                        try {
                            dVar.e(context, Xml.asAttributeSet(xmlPullParser));
                            c(dVar);
                        } catch (Exception e13) {
                            e11 = e13;
                            Log.e("KeyFrames", "unable to create ", e11);
                            dVar2 = dVar;
                            eventType = xmlPullParser.next();
                        }
                        dVar2 = dVar;
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (dVar2 != null && (hashMap2 = dVar2.f7329e) != null) {
                            ConstraintAttribute.i(context, xmlPullParser, hashMap2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && dVar2 != null && (hashMap = dVar2.f7329e) != null) {
                        ConstraintAttribute.i(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e14) {
            e14.printStackTrace();
        } catch (XmlPullParserException e15) {
            e15.printStackTrace();
        }
    }

    public void a(m mVar) {
        ArrayList arrayList = (ArrayList) this.f7370a.get(-1);
        if (arrayList != null) {
            mVar.b(arrayList);
        }
    }

    public void b(m mVar) {
        ArrayList arrayList = (ArrayList) this.f7370a.get(Integer.valueOf(mVar.f7453c));
        if (arrayList != null) {
            mVar.b(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) this.f7370a.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f(((ConstraintLayout.b) mVar.f7452b.getLayoutParams()).f7742c0)) {
                    mVar.a(dVar);
                }
            }
        }
    }

    public void c(d dVar) {
        if (!this.f7370a.containsKey(Integer.valueOf(dVar.f7326b))) {
            this.f7370a.put(Integer.valueOf(dVar.f7326b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) this.f7370a.get(Integer.valueOf(dVar.f7326b));
        if (arrayList != null) {
            arrayList.add(dVar);
        }
    }

    public ArrayList d(int i11) {
        return (ArrayList) this.f7370a.get(Integer.valueOf(i11));
    }
}
