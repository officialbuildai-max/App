package com.gyf.immersionbar;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements Cloneable {
    public View A;
    public int C;
    public int D;
    n L;

    /* renamed from: z, reason: collision with root package name */
    public View f33147z;

    /* renamed from: a, reason: collision with root package name */
    public int f33122a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f33123b = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: c, reason: collision with root package name */
    public int f33124c = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: d, reason: collision with root package name */
    public float f33125d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f33126e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f33127f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public float f33128g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f33129h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f33130i = false;

    /* renamed from: j, reason: collision with root package name */
    public BarHide f33131j = BarHide.FLAG_SHOW_BAR;

    /* renamed from: k, reason: collision with root package name */
    public boolean f33132k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f33133l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f33134m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f33135n = false;

    /* renamed from: o, reason: collision with root package name */
    public float f33136o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    public float f33137p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    public boolean f33138q = true;

    /* renamed from: r, reason: collision with root package name */
    public int f33139r = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: s, reason: collision with root package name */
    public int f33140s = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: t, reason: collision with root package name */
    Map f33141t = new HashMap();

    /* renamed from: u, reason: collision with root package name */
    public float f33142u = 0.0f;

    /* renamed from: v, reason: collision with root package name */
    public int f33143v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f33144w = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: x, reason: collision with root package name */
    public float f33145x = 0.0f;

    /* renamed from: y, reason: collision with root package name */
    public boolean f33146y = false;
    public boolean B = true;
    public boolean E = false;
    public boolean F = false;
    public int G = 18;
    public boolean H = true;
    public boolean I = true;
    public boolean J = true;
    public boolean K = true;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
