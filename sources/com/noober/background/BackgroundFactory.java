package com.noober.background;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BackgroundFactory implements LayoutInflater.Factory2 {
    private LayoutInflater.Factory mViewCreateFactory;
    private LayoutInflater.Factory2 mViewCreateFactory2;
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final Object[] mConstructorArgs = new Object[2];
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new androidx.collection.a();
    private static final HashMap<String, HashMap<String, Method>> methodMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f40110a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f40111b;

        a(Method method, Context context) {
            this.f40110a = method;
            this.f40111b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                this.f40110a.invoke(this.f40111b, null);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }

    private static View createView(Context context, String str, String str2) throws InflateException {
        String str3;
        Map<String, Constructor<? extends View>> map = sConstructorMap;
        Constructor<? extends View> constructor = map.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(sConstructorSignature);
                map.put(str, constructor);
            } catch (Exception unused) {
                Log.w("BackgroundLibrary", "cannot create 【" + str + "】 : ");
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(mConstructorArgs);
    }

    private static View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            try {
                Object[] objArr = mConstructorArgs;
                objArr[0] = context;
                objArr[1] = attributeSet;
                if (-1 != str.indexOf(46)) {
                    View createView = createView(context, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    return createView;
                }
                View createView2 = "View".equals(str) ? createView(context, str, "android.view.") : null;
                if (createView2 == null) {
                    createView2 = createView(context, str, "android.widget.");
                }
                if (createView2 == null) {
                    createView2 = createView(context, str, "android.webkit.");
                }
                objArr[0] = null;
                objArr[1] = null;
                return createView2;
            } catch (Exception unused) {
                Log.w("BackgroundLibrary", "cannot create 【" + str + "】 : ");
                Object[] objArr2 = mConstructorArgs;
                objArr2[0] = null;
                objArr2[1] = null;
                return null;
            }
        } catch (Throwable th2) {
            Object[] objArr3 = mConstructorArgs;
            objArr3[0] = null;
            objArr3[1] = null;
            throw th2;
        }
    }

    private static Method findDeclaredMethod(Class cls, String str) {
        Method method = null;
        try {
            method = cls.getDeclaredMethod(str, null);
            method.setAccessible(true);
            return method;
        } catch (NoSuchMethodException unused) {
            return cls.getSuperclass() != null ? findDeclaredMethod(cls.getSuperclass(), str) : method;
        }
    }

    private static Method findMethod(Class cls, String str) {
        try {
            return cls.getMethod(str, null);
        } catch (NoSuchMethodException unused) {
            return findDeclaredMethod(cls, str);
        }
    }

    private static Method getMethod(Class cls, String str) {
        Method method;
        HashMap<String, HashMap<String, Method>> hashMap = methodMap;
        HashMap<String, Method> hashMap2 = hashMap.get(cls.getCanonicalName());
        if (hashMap2 != null) {
            method = hashMap.get(cls.getCanonicalName()).get(str);
        } else {
            hashMap2 = new HashMap<>();
            hashMap.put(cls.getCanonicalName(), hashMap2);
            method = null;
        }
        if (method == null && (method = findMethod(cls, str)) != null) {
            hashMap2.put(str, method);
        }
        return method;
    }

    private static boolean hasGradientState(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.background_bl_checkable_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_checked_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_enabled_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_selected_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_pressed_gradient_startColor) || typedArray.hasValue(R.styleable.background_bl_focused_gradient_startColor);
    }

    private static boolean hasStatus(int i11, int i12) {
        return (i11 & i12) == i12;
    }

    private static void setBackground(Drawable drawable, View view, TypedArray typedArray) {
        float f11 = 0.0f;
        if (typedArray.hasValue(R.styleable.background_bl_stroke_width) && typedArray.hasValue(R.styleable.background_bl_stroke_position)) {
            float dimension = typedArray.getDimension(R.styleable.background_bl_stroke_width, 0.0f);
            int i11 = typedArray.getInt(R.styleable.background_bl_stroke_position, 0);
            float f12 = hasStatus(i11, 2) ? 0.0f : -dimension;
            float f13 = hasStatus(i11, 4) ? 0.0f : -dimension;
            float f14 = hasStatus(i11, 8) ? 0.0f : -dimension;
            float f15 = hasStatus(i11, 16) ? 0.0f : -dimension;
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
            layerDrawable.setLayerInset(0, (int) f12, (int) f13, (int) f14, (int) f15);
            drawable = layerDrawable;
        }
        if (typedArray.hasValue(R.styleable.background_bl_shape_alpha)) {
            float f16 = typedArray.getFloat(R.styleable.background_bl_shape_alpha, 0.0f);
            if (f16 >= 1.0f) {
                f11 = 255.0f;
            } else if (f16 > 0.0f) {
                f11 = f16 * 255.0f;
            }
            drawable.setAlpha((int) f11);
        }
        view.setBackground(drawable);
    }

    private static void setDrawable(Drawable drawable, View view, TypedArray typedArray, TypedArray typedArray2) {
        if (!(view instanceof TextView)) {
            setBackground(drawable, view, typedArray2);
            return;
        }
        if (!typedArray.hasValue(R.styleable.bl_other_bl_position)) {
            setBackground(drawable, view, typedArray2);
            return;
        }
        if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 1) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((TextView) view).setCompoundDrawables(drawable, null, null, null);
            return;
        }
        if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 2) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((TextView) view).setCompoundDrawables(null, drawable, null, null);
        } else if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 4) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((TextView) view).setCompoundDrawables(null, null, drawable, null);
        } else if (typedArray.getInt(R.styleable.bl_other_bl_position, 0) == 8) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((TextView) view).setCompoundDrawables(null, null, null, drawable);
        }
    }

    @Nullable
    public static View setViewBackground(Context context, AttributeSet attributeSet, View view) {
        return setViewBackground(null, context, attributeSet, view);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0184 A[Catch: all -> 0x009b, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:34:0x00d0, B:36:0x00d6, B:39:0x00dd, B:40:0x00e4, B:41:0x00e8, B:43:0x00ee, B:46:0x00f5, B:47:0x00fc, B:48:0x00fd, B:50:0x0104, B:52:0x0108, B:55:0x0180, B:57:0x0184, B:59:0x018a, B:60:0x01ba, B:62:0x01c3, B:64:0x01cb, B:67:0x01d4, B:68:0x01e0, B:70:0x01e8, B:72:0x01f4, B:74:0x0202, B:77:0x0195, B:79:0x0199, B:81:0x019f, B:82:0x01aa, B:84:0x01ae, B:86:0x01b4, B:87:0x0114, B:89:0x011a, B:90:0x0123, B:92:0x0129, B:93:0x013a, B:95:0x0140, B:96:0x0148, B:98:0x014e, B:100:0x0154, B:101:0x015c, B:102:0x0166, B:104:0x016c, B:106:0x017b), top: B:33:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c3 A[Catch: all -> 0x009b, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:34:0x00d0, B:36:0x00d6, B:39:0x00dd, B:40:0x00e4, B:41:0x00e8, B:43:0x00ee, B:46:0x00f5, B:47:0x00fc, B:48:0x00fd, B:50:0x0104, B:52:0x0108, B:55:0x0180, B:57:0x0184, B:59:0x018a, B:60:0x01ba, B:62:0x01c3, B:64:0x01cb, B:67:0x01d4, B:68:0x01e0, B:70:0x01e8, B:72:0x01f4, B:74:0x0202, B:77:0x0195, B:79:0x0199, B:81:0x019f, B:82:0x01aa, B:84:0x01ae, B:86:0x01b4, B:87:0x0114, B:89:0x011a, B:90:0x0123, B:92:0x0129, B:93:0x013a, B:95:0x0140, B:96:0x0148, B:98:0x014e, B:100:0x0154, B:101:0x015c, B:102:0x0166, B:104:0x016c, B:106:0x017b), top: B:33:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e8 A[Catch: all -> 0x009b, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:34:0x00d0, B:36:0x00d6, B:39:0x00dd, B:40:0x00e4, B:41:0x00e8, B:43:0x00ee, B:46:0x00f5, B:47:0x00fc, B:48:0x00fd, B:50:0x0104, B:52:0x0108, B:55:0x0180, B:57:0x0184, B:59:0x018a, B:60:0x01ba, B:62:0x01c3, B:64:0x01cb, B:67:0x01d4, B:68:0x01e0, B:70:0x01e8, B:72:0x01f4, B:74:0x0202, B:77:0x0195, B:79:0x0199, B:81:0x019f, B:82:0x01aa, B:84:0x01ae, B:86:0x01b4, B:87:0x0114, B:89:0x011a, B:90:0x0123, B:92:0x0129, B:93:0x013a, B:95:0x0140, B:96:0x0148, B:98:0x014e, B:100:0x0154, B:101:0x015c, B:102:0x0166, B:104:0x016c, B:106:0x017b), top: B:33:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0199 A[Catch: all -> 0x009b, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:34:0x00d0, B:36:0x00d6, B:39:0x00dd, B:40:0x00e4, B:41:0x00e8, B:43:0x00ee, B:46:0x00f5, B:47:0x00fc, B:48:0x00fd, B:50:0x0104, B:52:0x0108, B:55:0x0180, B:57:0x0184, B:59:0x018a, B:60:0x01ba, B:62:0x01c3, B:64:0x01cb, B:67:0x01d4, B:68:0x01e0, B:70:0x01e8, B:72:0x01f4, B:74:0x0202, B:77:0x0195, B:79:0x0199, B:81:0x019f, B:82:0x01aa, B:84:0x01ae, B:86:0x01b4, B:87:0x0114, B:89:0x011a, B:90:0x0123, B:92:0x0129, B:93:0x013a, B:95:0x0140, B:96:0x0148, B:98:0x014e, B:100:0x0154, B:101:0x015c, B:102:0x0166, B:104:0x016c, B:106:0x017b), top: B:33:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ae A[Catch: all -> 0x009b, Exception -> 0x00e5, TryCatch #1 {Exception -> 0x00e5, blocks: (B:34:0x00d0, B:36:0x00d6, B:39:0x00dd, B:40:0x00e4, B:41:0x00e8, B:43:0x00ee, B:46:0x00f5, B:47:0x00fc, B:48:0x00fd, B:50:0x0104, B:52:0x0108, B:55:0x0180, B:57:0x0184, B:59:0x018a, B:60:0x01ba, B:62:0x01c3, B:64:0x01cb, B:67:0x01d4, B:68:0x01e0, B:70:0x01e8, B:72:0x01f4, B:74:0x0202, B:77:0x0195, B:79:0x0199, B:81:0x019f, B:82:0x01aa, B:84:0x01ae, B:86:0x01b4, B:87:0x0114, B:89:0x011a, B:90:0x0123, B:92:0x0129, B:93:0x013a, B:95:0x0140, B:96:0x0148, B:98:0x014e, B:100:0x0154, B:101:0x015c, B:102:0x0166, B:104:0x016c, B:106:0x017b), top: B:33:0x00d0 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.view.View setViewBackground(java.lang.String r17, android.content.Context r18, android.util.AttributeSet r19, android.view.View r20) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.noober.background.BackgroundFactory.setViewBackground(java.lang.String, android.content.Context, android.util.AttributeSet, android.view.View):android.view.View");
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return onCreateView(str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View view = null;
        if (str.startsWith("com.noober.background.view")) {
            return null;
        }
        LayoutInflater.Factory2 factory2 = this.mViewCreateFactory2;
        if (factory2 != null) {
            View onCreateView = factory2.onCreateView(str, context, attributeSet);
            view = onCreateView == null ? this.mViewCreateFactory2.onCreateView(null, str, context, attributeSet) : onCreateView;
        } else {
            LayoutInflater.Factory factory = this.mViewCreateFactory;
            if (factory != null) {
                view = factory.onCreateView(str, context, attributeSet);
            }
        }
        return setViewBackground(str, context, attributeSet, view);
    }

    public void setInterceptFactory(LayoutInflater.Factory factory) {
        this.mViewCreateFactory = factory;
    }

    public void setInterceptFactory2(LayoutInflater.Factory2 factory2) {
        this.mViewCreateFactory2 = factory2;
    }
}
