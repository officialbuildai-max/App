package uw;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.card.MaterialCardView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsnet.downloader.adapter.u0;
import com.transsnet.downloader.popup.q;
import kotlin.jvm.internal.Intrinsics;
import oh.h;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private PopupWindow f77064a;

    /* renamed from: b, reason: collision with root package name */
    private u0.b f77065b;

    private final View c(Context context, final boolean z10) {
        String string;
        View inflate = LayoutInflater.from(context).inflate(R$layout.popup_report_layout, (ViewGroup) null);
        inflate.findViewById(R$id.menu_item1).setOnClickListener(new View.OnClickListener() { // from class: uw.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.d(c.this, z10, view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R$id.menu_item2);
        textView.setOnClickListener(new View.OnClickListener() { // from class: uw.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.e(c.this, z10, view);
            }
        });
        if (z10) {
            textView.setVisibility(8);
            string = textView.getResources().getString(R$string.str_unblock);
        } else {
            string = textView.getResources().getString(R$string.str_block);
        }
        textView.setText(string);
        Intrinsics.e(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, boolean z10, View view) {
        u0.b bVar = cVar.f77065b;
        if (bVar != null) {
            bVar.b(0, 0, 2, z10);
        }
        PopupWindow popupWindow = cVar.f77064a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c cVar, boolean z10, View view) {
        u0.b bVar = cVar.f77065b;
        if (bVar != null) {
            bVar.b(0, 0, 1, z10);
        }
        PopupWindow popupWindow = cVar.f77064a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void f(u0.b listener) {
        Intrinsics.h(listener, "listener");
        this.f77065b = listener;
    }

    public final void g(View anchorView, boolean z10) {
        Intrinsics.h(anchorView, "anchorView");
        Context context = anchorView.getContext();
        Intrinsics.g(context, "getContext(...)");
        View c11 = c(context, z10);
        PopupWindow popupWindow = new PopupWindow(c11, -2, -2, true);
        this.f77064a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int[] a11 = q.f59691a.a(anchorView, c11);
        h hVar = h.f71144a;
        Application a12 = Utils.a();
        Intrinsics.g(a12, "getApp(...)");
        int a13 = hVar.a(a12, 16.0f);
        int i11 = a11[0] - a13;
        a11[0] = i11;
        int i12 = a11[1] - a13;
        a11[1] = i12;
        PopupWindow popupWindow2 = this.f77064a;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(anchorView, MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START, i11, i12);
        }
    }
}
