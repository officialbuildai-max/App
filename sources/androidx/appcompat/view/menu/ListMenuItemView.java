package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.j0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements m.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    private h f1446a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f1447b;

    /* renamed from: c, reason: collision with root package name */
    private RadioButton f1448c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f1449d;

    /* renamed from: e, reason: collision with root package name */
    private CheckBox f1450e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f1451f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f1452g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f1453h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f1454i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f1455j;

    /* renamed from: k, reason: collision with root package name */
    private int f1456k;

    /* renamed from: l, reason: collision with root package name */
    private Context f1457l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1458m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f1459n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1460o;

    /* renamed from: p, reason: collision with root package name */
    private LayoutInflater f1461p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1462q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        j0 v11 = j0.v(getContext(), attributeSet, R$styleable.MenuView, i11, 0);
        this.f1455j = v11.g(R$styleable.MenuView_android_itemBackground);
        this.f1456k = v11.n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f1458m = v11.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f1457l = context;
        this.f1459n = v11.g(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f1460o = obtainStyledAttributes.hasValue(0);
        v11.x();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i11) {
        LinearLayout linearLayout = this.f1454i;
        if (linearLayout != null) {
            linearLayout.addView(view, i11);
        } else {
            addView(view, i11);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f1450e = checkBox;
        a(checkBox);
    }

    private void d() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f1447b = imageView;
        b(imageView, 0);
    }

    private void e() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f1448c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f1461p == null) {
            this.f1461p = LayoutInflater.from(getContext());
        }
        return this.f1461p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f1452g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1453h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1453h.getLayoutParams();
        rect.top += this.f1453h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public h getItemData() {
        return this.f1446a;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void initialize(h hVar, int i11) {
        this.f1446a = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        setTitle(hVar.i(this));
        setCheckable(hVar.isCheckable());
        setShortcut(hVar.A(), hVar.g());
        setIcon(hVar.getIcon());
        setEnabled(hVar.isEnabled());
        setSubMenuArrowVisible(hVar.hasSubMenu());
        setContentDescription(hVar.getContentDescription());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f1455j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f1449d = textView;
        int i11 = this.f1456k;
        if (i11 != -1) {
            textView.setTextAppearance(this.f1457l, i11);
        }
        this.f1451f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f1452g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1459n);
        }
        this.f1453h = (ImageView) findViewById(R$id.group_divider);
        this.f1454i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        if (this.f1447b != null && this.f1458m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1447b.getLayoutParams();
            int i13 = layoutParams.height;
            if (i13 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i13;
            }
        }
        super.onMeasure(i11, i12);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f1448c == null && this.f1450e == null) {
            return;
        }
        if (this.f1446a.m()) {
            if (this.f1448c == null) {
                e();
            }
            compoundButton = this.f1448c;
            view = this.f1450e;
        } else {
            if (this.f1450e == null) {
                c();
            }
            compoundButton = this.f1450e;
            view = this.f1448c;
        }
        if (z10) {
            compoundButton.setChecked(this.f1446a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1450e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1448c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f1446a.m()) {
            if (this.f1448c == null) {
                e();
            }
            compoundButton = this.f1448c;
        } else {
            if (this.f1450e == null) {
                c();
            }
            compoundButton = this.f1450e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f1462q = z10;
        this.f1458m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f1453h;
        if (imageView != null) {
            imageView.setVisibility((this.f1460o || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f1446a.z() || this.f1462q;
        if (z10 || this.f1458m) {
            ImageView imageView = this.f1447b;
            if (imageView == null && drawable == null && !this.f1458m) {
                return;
            }
            if (imageView == null) {
                d();
            }
            if (drawable == null && !this.f1458m) {
                this.f1447b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1447b;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1447b.getVisibility() != 0) {
                this.f1447b.setVisibility(0);
            }
        }
    }

    public void setShortcut(boolean z10, char c11) {
        int i11 = (z10 && this.f1446a.A()) ? 0 : 8;
        if (i11 == 0) {
            this.f1451f.setText(this.f1446a.h());
        }
        if (this.f1451f.getVisibility() != i11) {
            this.f1451f.setVisibility(i11);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1449d.getVisibility() != 8) {
                this.f1449d.setVisibility(8);
            }
        } else {
            this.f1449d.setText(charSequence);
            if (this.f1449d.getVisibility() != 0) {
                this.f1449d.setVisibility(0);
            }
        }
    }

    public boolean showsIcon() {
        return this.f1462q;
    }
}
