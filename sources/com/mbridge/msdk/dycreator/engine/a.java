package com.mbridge.msdk.dycreator.engine;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final Class[] f34872e = {Context.class, AttributeSet.class};

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Constructor> f34873f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private static String f34874g = "com.mbridge.msdk.dycreator.baseview.MB";

    /* renamed from: b, reason: collision with root package name */
    protected final Context f34876b;

    /* renamed from: d, reason: collision with root package name */
    private long f34878d;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f34875a = true;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f34877c = new Object[2];

    public a(Context context) {
        this.f34876b = context;
    }

    private void a(XmlPullParser xmlPullParser, View view) throws XmlPullParserException, IOException {
        int next;
        view.requestFocus();
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        } while (next != 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        if (r8 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        b(r0, r2, r1);
        r7.addView(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
    
        r2.setLayoutParams(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
    
        if (r8 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.xmlpull.v1.XmlPullParser r6, android.view.View r7, android.util.AttributeSet r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof android.view.ViewGroup
            if (r0 == 0) goto Lbd
            r0 = 0
            r1 = 0
            java.lang.String r2 = "layout"
            int r0 = r8.getAttributeResourceValue(r1, r2, r0)
            if (r0 != 0) goto L38
            java.lang.String r6 = r8.getAttributeValue(r1, r2)
            if (r6 != 0) goto L1c
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />"
            r6.<init>(r7)
            throw r6
        L1c:
            android.view.InflateException r7 = new android.view.InflateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "You must specifiy a valid layout reference. The layout ID "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = " is not valid."
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L38:
            android.content.Context r1 = r5.a()
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.XmlResourceParser r0 = r1.getLayout(r0)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)     // Catch: java.lang.Throwable -> L65
        L48:
            int r2 = r0.next()     // Catch: java.lang.Throwable -> L65
            r3 = 1
            r4 = 2
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            goto L48
        L53:
            if (r2 != r4) goto L9e
            java.lang.String r2 = r0.getName()     // Catch: java.lang.Throwable -> L65
            java.lang.String r4 = "merge"
            boolean r4 = r4.equals(r2)     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L67
            r5.b(r0, r7, r1)     // Catch: java.lang.Throwable -> L65
            goto L85
        L65:
            r6 = move-exception
            goto Lb9
        L67:
            android.view.View r2 = r5.a(r2, r1)     // Catch: java.lang.Throwable -> L65
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch: java.lang.Throwable -> L65
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r8)     // Catch: java.lang.Throwable -> L74 java.lang.RuntimeException -> L76
            if (r8 == 0) goto L7f
            goto L7c
        L74:
            r6 = move-exception
            goto L9d
        L76:
            android.view.ViewGroup$LayoutParams r8 = r7.generateLayoutParams(r1)     // Catch: java.lang.Throwable -> L74
            if (r8 == 0) goto L7f
        L7c:
            r2.setLayoutParams(r8)     // Catch: java.lang.Throwable -> L65
        L7f:
            r5.b(r0, r2, r1)     // Catch: java.lang.Throwable -> L65
            r7.addView(r2)     // Catch: java.lang.Throwable -> L65
        L85:
            r0.close()
            int r7 = r6.getDepth()
        L8c:
            int r8 = r6.next()
            r0 = 3
            if (r8 != r0) goto L99
            int r0 = r6.getDepth()
            if (r0 <= r7) goto L9c
        L99:
            if (r8 == r3) goto L9c
            goto L8c
        L9c:
            return
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L65
        L9e:
            android.view.InflateException r6 = new android.view.InflateException     // Catch: java.lang.Throwable -> L65
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
            r7.<init>()     // Catch: java.lang.Throwable -> L65
            java.lang.String r8 = r0.getPositionDescription()     // Catch: java.lang.Throwable -> L65
            r7.append(r8)     // Catch: java.lang.Throwable -> L65
            java.lang.String r8 = ": No start tag found!"
            r7.append(r8)     // Catch: java.lang.Throwable -> L65
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L65
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L65
            throw r6     // Catch: java.lang.Throwable -> L65
        Lb9:
            r0.close()
            throw r6
        Lbd:
            android.view.InflateException r6 = new android.view.InflateException
            java.lang.String r7 = "<include /> can only be used inside of a ViewGroup"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.engine.a.a(org.xmlpull.v1.XmlPullParser, android.view.View, android.util.AttributeSet):void");
    }

    private void b(XmlPullParser xmlPullParser, View view, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("requestFocus".equals(name)) {
                    a(xmlPullParser, view);
                } else if ("include".equals(name)) {
                    if (xmlPullParser.getDepth() == 0) {
                        throw new InflateException("<include /> cannot be the root element");
                    }
                    a(xmlPullParser, view, attributeSet);
                } else {
                    if ("merge".equals(name)) {
                        throw new InflateException("<merge /> must be the root element");
                    }
                    View a11 = a(name, attributeSet);
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroup.LayoutParams generateLayoutParams = viewGroup.generateLayoutParams(attributeSet);
                    b(xmlPullParser, a11, attributeSet);
                    viewGroup.addView(a11, generateLayoutParams);
                }
            }
        }
    }

    public Context a() {
        return this.f34876b;
    }

    View a(String str, AttributeSet attributeSet) {
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        PrintStream printStream = System.out;
        printStream.println("******** Creating view: " + str);
        try {
            View b11 = -1 == str.indexOf(46) ? b(str, attributeSet) : a(str, (String) null, attributeSet);
            printStream.println("Created view is: " + b11);
            return b11;
        } catch (InflateException e11) {
            throw e11;
        } catch (ClassNotFoundException e12) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e12);
            throw inflateException;
        } catch (Exception e13) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e13);
            throw inflateException2;
        }
    }

    public View a(String str, ViewGroup viewGroup) {
        return a(str, viewGroup, viewGroup != null);
    }

    public View a(String str, ViewGroup viewGroup, boolean z10) {
        this.f34878d = System.currentTimeMillis();
        System.out.println("INFLATING from resource: " + str);
        return a(a(str), viewGroup, z10);
    }

    public final View a(String str, String str2, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        String str3;
        HashMap<String, Constructor> hashMap = f34873f;
        Constructor<?> constructor = hashMap.get(str);
        Class<?> cls = null;
        if (constructor == null) {
            try {
                ClassLoader classLoader = this.f34876b.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                cls = classLoader.loadClass(str3);
                constructor = cls.getConstructor(f34872e);
                hashMap.put(str, constructor);
            } catch (ClassNotFoundException e11) {
                throw e11;
            } catch (NoSuchMethodException e12) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(attributeSet.getPositionDescription());
                sb2.append(": Error inflating class ");
                if (str2 != null) {
                    str = str2 + str;
                }
                sb2.append(str);
                InflateException inflateException = new InflateException(sb2.toString());
                inflateException.initCause(e12);
                throw inflateException;
            } catch (Exception e13) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(attributeSet.getPositionDescription());
                sb3.append(": Error inflating class ");
                sb3.append(cls == null ? "<unknown>" : cls.getName());
                InflateException inflateException2 = new InflateException(sb3.toString());
                inflateException2.initCause(e13);
                throw inflateException2;
            }
        }
        Object[] objArr = this.f34877c;
        objArr[1] = attributeSet;
        return (View) constructor.newInstance(objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, java.lang.Object, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View] */
    public View a(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z10) {
        int next;
        ViewGroup.LayoutParams layoutParams;
        synchronized (this.f34877c) {
            try {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                this.f34877c[0] = this.f34876b;
                do {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                }
                String name = xmlPullParser.getName();
                PrintStream printStream = System.out;
                printStream.println("**************************");
                printStream.println("Creating root view: " + name);
                printStream.println("**************************");
                if (!"merge".equals(name)) {
                    View a11 = a(name, asAttributeSet);
                    if (viewGroup != 0) {
                        printStream.println("Creating params from root: " + ((Object) viewGroup));
                        layoutParams = viewGroup.generateLayoutParams(asAttributeSet);
                        if (!z10) {
                            a11.setLayoutParams(layoutParams);
                        }
                    } else {
                        layoutParams = null;
                    }
                    printStream.println("-----> start inflating children");
                    b(xmlPullParser, a11, asAttributeSet);
                    printStream.println("-----> done inflating children");
                    if (viewGroup != 0 && z10) {
                        viewGroup.addView(a11, layoutParams);
                    }
                    if (viewGroup == 0 || !z10) {
                        viewGroup = a11;
                    }
                } else {
                    if (viewGroup == 0 || !z10) {
                        throw new InflateException("<merge /> can be used only with a valid ViewGroup root and attachToRoot=true");
                    }
                    b(xmlPullParser, viewGroup, asAttributeSet);
                }
            } catch (IOException e11) {
                InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e11.getMessage());
                inflateException.initCause(e11);
                throw inflateException;
            } catch (XmlPullParserException e12) {
                InflateException inflateException2 = new InflateException(e12.getMessage());
                inflateException2.initCause(e12);
                throw inflateException2;
            } finally {
            }
        }
        return viewGroup;
    }

    public XmlPullParser a(String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new FileInputStream(str), "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return newPullParser;
    }

    protected View b(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return (str.equals("MBStarLevelLayoutView") || str.equals("LuckPan")) ? a(str, "", attributeSet) : a(str, f34874g, attributeSet);
    }
}
