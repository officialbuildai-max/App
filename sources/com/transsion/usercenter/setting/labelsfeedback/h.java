package com.transsion.usercenter.setting.labelsfeedback;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.usercenter.setting.labelsfeedback.model.FBContact;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsnet.loginapi.bean.Country;
import fw.g0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class h extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final FbDataModel f57559a;

    /* renamed from: b, reason: collision with root package name */
    private final i f57560b;

    /* renamed from: c, reason: collision with root package name */
    private a f57561c;

    /* loaded from: classes7.dex */
    public final class a extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final LinearLayout f57562a;

        /* renamed from: b, reason: collision with root package name */
        private final UCEditText f57563b;

        /* renamed from: c, reason: collision with root package name */
        private final AppCompatTextView f57564c;

        /* renamed from: d, reason: collision with root package name */
        private final ShapeableImageView f57565d;

        /* renamed from: e, reason: collision with root package name */
        private final AppCompatEditText f57566e;

        /* renamed from: f, reason: collision with root package name */
        private final AppCompatEditText f57567f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ h f57568g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, g0 binding) {
            super(binding.getRoot());
            Intrinsics.h(binding, "binding");
            this.f57568g = hVar;
            LinearLayout root = binding.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            this.f57562a = root;
            UCEditText editText = binding.f62788d;
            Intrinsics.g(editText, "editText");
            this.f57563b = editText;
            AppCompatTextView countTextView = binding.f62786b;
            Intrinsics.g(countTextView, "countTextView");
            this.f57564c = countTextView;
            ShapeableImageView imageView = binding.f62789e;
            Intrinsics.g(imageView, "imageView");
            this.f57565d = imageView;
            AppCompatEditText countryEditText = binding.f62787c;
            Intrinsics.g(countryEditText, "countryEditText");
            this.f57566e = countryEditText;
            AppCompatEditText phoneEditText = binding.f62790f;
            Intrinsics.g(phoneEditText, "phoneEditText");
            this.f57567f = phoneEditText;
        }

        public final AppCompatTextView f() {
            return this.f57564c;
        }

        public final AppCompatEditText g() {
            return this.f57566e;
        }

        public final UCEditText h() {
            return this.f57563b;
        }

        public final ShapeableImageView i() {
            return this.f57565d;
        }

        public final AppCompatEditText j() {
            return this.f57567f;
        }

        public final LinearLayout k() {
            return this.f57562a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f57569a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f57570b;

        public b(a aVar, h hVar) {
            this.f57569a = aVar;
            this.f57570b = hVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj;
            int length = editable != null ? editable.length() : 0;
            this.f57569a.f().setText(length + "/500");
            this.f57570b.m().setContent((editable == null || (obj = editable.toString()) == null) ? null : StringsKt.n1(obj).toString());
            i l11 = this.f57570b.l();
            if (l11 != null) {
                l11.b(this.f57570b);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            FBContact contact = h.this.m().getContact();
            if (editable == null || (str = editable.toString()) == null) {
                str = "";
            }
            contact.setPhone(str);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public h(FbDataModel model, i iVar) {
        Intrinsics.h(model, "model");
        this.f57559a = model;
        this.f57560b = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(h hVar, View view) {
        i iVar = hVar.f57560b;
        if (iVar != null) {
            iVar.e(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(h hVar, View view) {
        i iVar = hVar.f57560b;
        if (iVar != null) {
            iVar.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h hVar, View view) {
        i iVar = hVar.f57560b;
        if (iVar != null) {
            iVar.k(hVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public final void j(Country country) {
        AppCompatEditText g11;
        if (country != null) {
            this.f57559a.getContact().setCountry(country);
            String str = country.getCountry_s() + " +" + country.getCode();
            a aVar = this.f57561c;
            if (aVar == null || (g11 = aVar.g()) == null) {
                return;
            }
            g11.setText(str);
        }
    }

    public final void k(String str) {
        ShapeableImageView i11;
        i iVar;
        this.f57559a.setImagePath(str);
        a aVar = this.f57561c;
        if (aVar == null || (i11 = aVar.i()) == null || (iVar = this.f57560b) == null) {
            return;
        }
        iVar.c(this, i11);
    }

    public final i l() {
        return this.f57560b;
    }

    public final FbDataModel m() {
        return this.f57559a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11) {
        Intrinsics.h(holder, "holder");
        holder.k().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.o(h.this, view);
            }
        });
        holder.i().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.p(h.this, view);
            }
        });
        holder.f().setText("0/500");
        holder.h().addTextChangedListener(new b(holder, this));
        holder.g().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.q(h.this, view);
            }
        });
        holder.j().addTextChangedListener(new c());
        String content = this.f57559a.getContent();
        if (content != null) {
            holder.h().setText(new SpannableStringBuilder(content));
        }
        k(this.f57559a.getImagePath());
        j(this.f57559a.getContact().getCountry());
        holder.j().setText(new SpannableStringBuilder(this.f57559a.getContact().getPhone()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        g0 c11 = g0.c(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        a aVar = new a(this, c11);
        this.f57561c = aVar;
        return aVar;
    }
}
