package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c0 extends Resources {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f2042a;

    public c0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2042a = resources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable a(int i11) {
        return super.getDrawable(i11);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i11) {
        return this.f2042a.getAnimation(i11);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i11) {
        return this.f2042a.getBoolean(i11);
    }

    @Override // android.content.res.Resources
    public int getColor(int i11) {
        return this.f2042a.getColor(i11);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i11) {
        return this.f2042a.getColorStateList(i11);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f2042a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i11) {
        return this.f2042a.getDimension(i11);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i11) {
        return this.f2042a.getDimensionPixelOffset(i11);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i11) {
        return this.f2042a.getDimensionPixelSize(i11);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f2042a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i11, Resources.Theme theme) {
        return y0.h.e(this.f2042a, i11, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i11, int i12) {
        return y0.h.f(this.f2042a, i11, i12, null);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i11, int i12, Resources.Theme theme) {
        return y0.h.f(this.f2042a, i11, i12, theme);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i11, int i12, int i13) {
        return this.f2042a.getFraction(i11, i12, i13);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f2042a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i11) {
        return this.f2042a.getIntArray(i11);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i11) {
        return this.f2042a.getInteger(i11);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i11) {
        return this.f2042a.getLayout(i11);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i11) {
        return this.f2042a.getMovie(i11);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i11, int i12) {
        return this.f2042a.getQuantityString(i11, i12);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i11, int i12, Object... objArr) {
        return this.f2042a.getQuantityString(i11, i12, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i11, int i12) {
        return this.f2042a.getQuantityText(i11, i12);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i11) {
        return this.f2042a.getResourceEntryName(i11);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i11) {
        return this.f2042a.getResourceName(i11);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i11) {
        return this.f2042a.getResourcePackageName(i11);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i11) {
        return this.f2042a.getResourceTypeName(i11);
    }

    @Override // android.content.res.Resources
    public String getString(int i11) {
        return this.f2042a.getString(i11);
    }

    @Override // android.content.res.Resources
    public String getString(int i11, Object... objArr) {
        return this.f2042a.getString(i11, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i11) {
        return this.f2042a.getStringArray(i11);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i11) {
        return this.f2042a.getText(i11);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i11, CharSequence charSequence) {
        return this.f2042a.getText(i11, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i11) {
        return this.f2042a.getTextArray(i11);
    }

    @Override // android.content.res.Resources
    public void getValue(int i11, TypedValue typedValue, boolean z10) {
        this.f2042a.getValue(i11, typedValue, z10);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z10) {
        this.f2042a.getValue(str, typedValue, z10);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i11, int i12, TypedValue typedValue, boolean z10) {
        this.f2042a.getValueForDensity(i11, i12, typedValue, z10);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i11) {
        return this.f2042a.getXml(i11);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2042a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i11) {
        return this.f2042a.obtainTypedArray(i11);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i11) {
        return this.f2042a.openRawResource(i11);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i11, TypedValue typedValue) {
        return this.f2042a.openRawResource(i11, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i11) {
        return this.f2042a.openRawResourceFd(i11);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f2042a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f2042a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f2042a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
