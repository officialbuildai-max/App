package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object E = "CONFIRM_BUTTON_TAG";
    static final Object F = "CANCEL_BUTTON_TAG";
    static final Object G = "TOGGLE_BUTTON_TAG";
    private Button A;
    private boolean B;
    private CharSequence C;
    private CharSequence D;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f28859a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashSet f28860b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f28861c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    private final LinkedHashSet f28862d = new LinkedHashSet();

    /* renamed from: e, reason: collision with root package name */
    private int f28863e;

    /* renamed from: f, reason: collision with root package name */
    private DateSelector f28864f;

    /* renamed from: g, reason: collision with root package name */
    private p f28865g;

    /* renamed from: h, reason: collision with root package name */
    private CalendarConstraints f28866h;

    /* renamed from: i, reason: collision with root package name */
    private DayViewDecorator f28867i;

    /* renamed from: j, reason: collision with root package name */
    private MaterialCalendar f28868j;

    /* renamed from: k, reason: collision with root package name */
    private int f28869k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f28870l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28871m;

    /* renamed from: n, reason: collision with root package name */
    private int f28872n;

    /* renamed from: o, reason: collision with root package name */
    private int f28873o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f28874p;

    /* renamed from: q, reason: collision with root package name */
    private int f28875q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f28876r;

    /* renamed from: s, reason: collision with root package name */
    private int f28877s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f28878t;

    /* renamed from: u, reason: collision with root package name */
    private int f28879u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f28880v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f28881w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f28882x;

    /* renamed from: y, reason: collision with root package name */
    private CheckableImageButton f28883y;

    /* renamed from: z, reason: collision with root package name */
    private ab.i f28884z;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.f28859a.iterator();
            if (!it.hasNext()) {
                MaterialDatePicker.this.dismiss();
            } else {
                android.support.v4.media.session.c.a(it.next());
                MaterialDatePicker.this.j0();
                throw null;
            }
        }
    }

    /* loaded from: classes4.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialDatePicker.this.f28860b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialDatePicker.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28887a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f28888b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f28889c;

        c(int i11, View view, int i12) {
            this.f28887a = i11;
            this.f28888b = view;
            this.f28889c = i12;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i11 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).f79249b;
            if (this.f28887a >= 0) {
                this.f28888b.getLayoutParams().height = this.f28887a + i11;
                View view2 = this.f28888b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f28888b;
            view3.setPadding(view3.getPaddingLeft(), this.f28889c + i11, this.f28888b.getPaddingRight(), this.f28888b.getPaddingBottom());
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends o {
        d() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a() {
            MaterialDatePicker.this.A.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.o
        public void b(Object obj) {
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.s0(materialDatePicker.h0());
            MaterialDatePicker.this.A.setEnabled(MaterialDatePicker.this.e0().isSelectionComplete());
        }
    }

    private static Drawable c0(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, g.a.b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], g.a.b(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void d0(Window window) {
        if (this.B) {
            return;
        }
        View findViewById = requireView().findViewById(R$id.fullscreen_header);
        com.google.android.material.internal.e.a(window, true, f0.h(findViewById), null);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById, new c(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop()));
        this.B = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector e0() {
        if (this.f28864f == null) {
            this.f28864f = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f28864f;
    }

    private static CharSequence f0(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] split = TextUtils.split(String.valueOf(charSequence), "\n");
        return split.length > 1 ? split[0] : charSequence;
    }

    private String g0() {
        return e0().getSelectionContentDescription(requireContext());
    }

    private static int i0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i11 = Month.e().f28898c;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i11) + ((i11 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int k0(Context context) {
        int i11 = this.f28863e;
        return i11 != 0 ? i11 : e0().getDefaultThemeResId(context);
    }

    private void l0(Context context) {
        this.f28883y.setTag(G);
        this.f28883y.setImageDrawable(c0(context));
        this.f28883y.setChecked(this.f28872n != 0);
        ViewCompat.setAccessibilityDelegate(this.f28883y, null);
        u0(this.f28883y);
        this.f28883y.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker.this.p0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m0(Context context) {
        return q0(context, R.attr.windowFullscreen);
    }

    private boolean n0() {
        return getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o0(Context context) {
        return q0(context, R$attr.nestedScrollable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        this.A.setEnabled(e0().isSelectionComplete());
        this.f28883y.toggle();
        this.f28872n = this.f28872n == 1 ? 0 : 1;
        u0(this.f28883y);
        r0();
    }

    static boolean q0(Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(xa.b.d(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i11});
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    private void r0() {
        int k02 = k0(requireContext());
        MaterialCalendar n02 = MaterialCalendar.n0(e0(), k02, this.f28866h, this.f28867i);
        this.f28868j = n02;
        p pVar = n02;
        if (this.f28872n == 1) {
            pVar = MaterialTextInputPicker.X(e0(), k02, this.f28866h);
        }
        this.f28865g = pVar;
        t0();
        s0(h0());
        androidx.fragment.app.w p11 = getChildFragmentManager().p();
        p11.s(R$id.mtrl_calendar_frame, this.f28865g);
        p11.k();
        this.f28865g.V(new d());
    }

    private void t0() {
        this.f28881w.setText((this.f28872n == 1 && n0()) ? this.D : this.C);
    }

    private void u0(CheckableImageButton checkableImageButton) {
        this.f28883y.setContentDescription(this.f28872n == 1 ? checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    public String h0() {
        return e0().getSelectionDisplayString(getContext());
    }

    public final Object j0() {
        return e0().getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f28861c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f28863e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f28864f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f28866h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f28867i = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f28869k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f28870l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f28872n = bundle.getInt("INPUT_MODE_KEY");
        this.f28873o = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f28874p = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f28875q = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f28876r = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f28877s = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f28878t = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f28879u = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f28880v = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.f28870l;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.f28869k);
        }
        this.C = charSequence;
        this.D = f0(charSequence);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), k0(requireContext()));
        Context context = dialog.getContext();
        this.f28871m = m0(context);
        this.f28884z = new ab.i(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialCalendar, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        int color = obtainStyledAttributes.getColor(R$styleable.MaterialCalendar_backgroundTint, 0);
        obtainStyledAttributes.recycle();
        this.f28884z.S(context);
        this.f28884z.d0(ColorStateList.valueOf(color));
        this.f28884z.c0(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f28871m ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.f28867i;
        if (dayViewDecorator != null) {
            dayViewDecorator.initialize(context);
        }
        if (this.f28871m) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(i0(context), -2));
        } else {
            inflate.findViewById(R$id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(i0(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.f28882x = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.f28883y = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        this.f28881w = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        l0(context);
        this.A = (Button) inflate.findViewById(R$id.confirm_button);
        if (e0().isSelectionComplete()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
        this.A.setTag(E);
        CharSequence charSequence = this.f28874p;
        if (charSequence != null) {
            this.A.setText(charSequence);
        } else {
            int i11 = this.f28873o;
            if (i11 != 0) {
                this.A.setText(i11);
            }
        }
        CharSequence charSequence2 = this.f28876r;
        if (charSequence2 != null) {
            this.A.setContentDescription(charSequence2);
        } else if (this.f28875q != 0) {
            this.A.setContentDescription(getContext().getResources().getText(this.f28875q));
        }
        this.A.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag(F);
        CharSequence charSequence3 = this.f28878t;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i12 = this.f28877s;
            if (i12 != 0) {
                button.setText(i12);
            }
        }
        CharSequence charSequence4 = this.f28880v;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f28879u != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f28879u));
        }
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f28862d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f28863e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f28864f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f28866h);
        MaterialCalendar materialCalendar = this.f28868j;
        Month i02 = materialCalendar == null ? null : materialCalendar.i0();
        if (i02 != null) {
            bVar.b(i02.f28900e);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f28867i);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f28869k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f28870l);
        bundle.putInt("INPUT_MODE_KEY", this.f28872n);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f28873o);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f28874p);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f28875q);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f28876r);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f28877s);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f28878t);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f28879u);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f28880v);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f28871m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f28884z);
            d0(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f28884z, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new sa.a(requireDialog(), rect));
        }
        r0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f28865g.W();
        super.onStop();
    }

    void s0(String str) {
        this.f28882x.setContentDescription(g0());
        this.f28882x.setText(str);
    }
}
