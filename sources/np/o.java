package np;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes6.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private int f70646a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f70647b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f70648c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f70649d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f70650e = false;

    public static void a(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
