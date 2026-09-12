package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.NavDeepLink;
import androidx.navigation.d;
import androidx.navigation.l;
import com.cloud.tmc.integration.event.EventConstants;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public static final a f13987c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f13988d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final Context f13989a;

    /* renamed from: b, reason: collision with root package name */
    private final q f13990b;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a(TypedValue value, o oVar, o expectedNavType, String str, String foundType) {
            Intrinsics.h(value, "value");
            Intrinsics.h(expectedNavType, "expectedNavType");
            Intrinsics.h(foundType, "foundType");
            if (oVar == null || oVar == expectedNavType) {
                return oVar == null ? expectedNavType : oVar;
            }
            throw new XmlPullParserException("Type is " + ((Object) str) + " but found " + foundType + ": " + value.data);
        }
    }

    public k(Context context, q navigatorProvider) {
        Intrinsics.h(context, "context");
        Intrinsics.h(navigatorProvider, "navigatorProvider");
        this.f13989a = context;
        this.f13990b = navigatorProvider;
    }

    private final NavDestination a(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i11) {
        int depth;
        q qVar = this.f13990b;
        String name = xmlResourceParser.getName();
        Intrinsics.g(name, "parser.name");
        NavDestination a11 = qVar.d(name).a();
        a11.s(this.f13989a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                if (Intrinsics.c("argument", name2)) {
                    f(resources, a11, attributeSet, i11);
                } else if (Intrinsics.c("deepLink", name2)) {
                    g(resources, a11, attributeSet);
                } else if (Intrinsics.c(EventConstants.KEY_ACTION, name2)) {
                    c(resources, a11, attributeSet, xmlResourceParser, i11);
                } else if (Intrinsics.c("include", name2) && (a11 instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.NavInclude);
                    Intrinsics.g(obtainAttributes, "res.obtainAttributes(att…n.R.styleable.NavInclude)");
                    ((NavGraph) a11).z(b(obtainAttributes.getResourceId(R$styleable.NavInclude_graph, 0)));
                    Unit unit = Unit.f67184a;
                    obtainAttributes.recycle();
                } else if (a11 instanceof NavGraph) {
                    ((NavGraph) a11).z(a(resources, xmlResourceParser, attributeSet, i11));
                }
            }
        }
        return a11;
    }

    private final void c(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i11) {
        int depth;
        Context context = this.f13989a;
        int[] NavAction = androidx.navigation.common.R$styleable.NavAction;
        Intrinsics.g(NavAction, "NavAction");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NavAction, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_android_id, 0);
        c cVar = new c(obtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_destination, 0), null, null, 6, null);
        l.a aVar = new l.a();
        aVar.d(obtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_launchSingleTop, false));
        aVar.j(obtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_restoreState, false));
        aVar.g(obtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_popUpTo, -1), obtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_popUpToInclusive, false), obtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_popUpToSaveState, false));
        aVar.b(obtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_enterAnim, -1));
        aVar.c(obtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_exitAnim, -1));
        aVar.e(obtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_popEnterAnim, -1));
        aVar.f(obtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_popExitAnim, -1));
        cVar.e(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && Intrinsics.c("argument", xmlResourceParser.getName())) {
                e(resources, bundle, attributeSet, i11);
            }
        }
        if (!bundle.isEmpty()) {
            cVar.d(bundle);
        }
        navDestination.t(resourceId, cVar);
        obtainStyledAttributes.recycle();
    }

    private final d d(TypedArray typedArray, Resources resources, int i11) {
        d.a aVar = new d.a();
        int i12 = 0;
        aVar.c(typedArray.getBoolean(androidx.navigation.common.R$styleable.NavArgument_nullable, false));
        ThreadLocal threadLocal = f13988d;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R$styleable.NavArgument_argType);
        Object obj = null;
        o a11 = string != null ? o.f14018c.a(string, resources.getResourcePackageName(i11)) : null;
        if (typedArray.getValue(androidx.navigation.common.R$styleable.NavArgument_android_defaultValue, typedValue)) {
            o oVar = o.f14020e;
            if (a11 == oVar) {
                int i13 = typedValue.resourceId;
                if (i13 != 0) {
                    i12 = i13;
                } else if (typedValue.type != 16 || typedValue.data != 0) {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a11.b() + ". Must be a reference to a resource.");
                }
                obj = Integer.valueOf(i12);
            } else {
                int i14 = typedValue.resourceId;
                if (i14 != 0) {
                    if (a11 != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a11.b() + ". You must use a \"" + oVar.b() + "\" type to reference other resources.");
                    }
                    obj = Integer.valueOf(i14);
                    a11 = oVar;
                } else if (a11 == o.f14028m) {
                    obj = typedArray.getString(androidx.navigation.common.R$styleable.NavArgument_android_defaultValue);
                } else {
                    int i15 = typedValue.type;
                    if (i15 == 3) {
                        String obj2 = typedValue.string.toString();
                        if (a11 == null) {
                            a11 = o.f14018c.b(obj2);
                        }
                        obj = a11.h(obj2);
                    } else if (i15 == 4) {
                        a11 = f13987c.a(typedValue, a11, o.f14024i, string, "float");
                        obj = Float.valueOf(typedValue.getFloat());
                    } else if (i15 == 5) {
                        a11 = f13987c.a(typedValue, a11, o.f14019d, string, "dimension");
                        obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i15 == 18) {
                        a11 = f13987c.a(typedValue, a11, o.f14026k, string, "boolean");
                        obj = Boolean.valueOf(typedValue.data != 0);
                    } else {
                        if (i15 < 16 || i15 > 31) {
                            throw new XmlPullParserException(Intrinsics.q("unsupported argument type ", Integer.valueOf(typedValue.type)));
                        }
                        o oVar2 = o.f14024i;
                        if (a11 == oVar2) {
                            a11 = f13987c.a(typedValue, a11, oVar2, string, "float");
                            obj = Float.valueOf(typedValue.data);
                        } else {
                            a11 = f13987c.a(typedValue, a11, o.f14019d, string, "integer");
                            obj = Integer.valueOf(typedValue.data);
                        }
                    }
                }
            }
        }
        if (obj != null) {
            aVar.b(obj);
        }
        if (a11 != null) {
            aVar.d(a11);
        }
        return aVar.a();
    }

    private final void e(Resources resources, Bundle bundle, AttributeSet attributeSet, int i11) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavArgument);
        Intrinsics.g(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(androidx.navigation.common.R$styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        d d11 = d(obtainAttributes, resources, i11);
        if (d11.b()) {
            d11.d(string, bundle);
        }
        Unit unit = Unit.f67184a;
        obtainAttributes.recycle();
    }

    private final void f(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i11) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavArgument);
        Intrinsics.g(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(androidx.navigation.common.R$styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        navDestination.a(string, d(obtainAttributes, resources, i11));
        Unit unit = Unit.f67184a;
        obtainAttributes.recycle();
    }

    private final void g(Resources resources, NavDestination navDestination, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavDeepLink);
        Intrinsics.g(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String string = obtainAttributes.getString(androidx.navigation.common.R$styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(androidx.navigation.common.R$styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(androidx.navigation.common.R$styleable.NavDeepLink_mimeType);
        if ((string == null || string.length() == 0) && ((string2 == null || string2.length() == 0) && (string3 == null || string3.length() == 0))) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.a aVar = new NavDeepLink.a();
        if (string != null) {
            String packageName = this.f13989a.getPackageName();
            Intrinsics.g(packageName, "context.packageName");
            aVar.d(StringsKt.Q(string, "${applicationId}", packageName, false, 4, null));
        }
        if (string2 != null && string2.length() != 0) {
            String packageName2 = this.f13989a.getPackageName();
            Intrinsics.g(packageName2, "context.packageName");
            aVar.b(StringsKt.Q(string2, "${applicationId}", packageName2, false, 4, null));
        }
        if (string3 != null) {
            String packageName3 = this.f13989a.getPackageName();
            Intrinsics.g(packageName3, "context.packageName");
            aVar.c(StringsKt.Q(string3, "${applicationId}", packageName3, false, 4, null));
        }
        navDestination.c(aVar.a());
        Unit unit = Unit.f67184a;
        obtainAttributes.recycle();
    }

    public final NavGraph b(int i11) {
        int next;
        Resources res = this.f13989a.getResources();
        XmlResourceParser xml = res.getXml(i11);
        Intrinsics.g(xml, "res.getXml(graphResId)");
        AttributeSet attrs = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e11) {
                    throw new RuntimeException("Exception inflating " + ((Object) res.getResourceName(i11)) + " line " + xml.getLineNumber(), e11);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        Intrinsics.g(res, "res");
        Intrinsics.g(attrs, "attrs");
        NavDestination a11 = a(res, xml, attrs, i11);
        if (a11 instanceof NavGraph) {
            return (NavGraph) a11;
        }
        throw new IllegalArgumentException(("Root element <" + ((Object) name) + "> did not inflate into a NavGraph").toString());
    }
}
