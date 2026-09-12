package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    final FragmentManager f9520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f9521a;

        a(u uVar) {
            this.f9521a = uVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment k11 = this.f9521a.k();
            this.f9521a.m();
            SpecialEffectsController.n((ViewGroup) k11.mView.getParent(), j.this.f9520a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FragmentManager fragmentManager) {
        this.f9520a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        u x10;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f9520a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !h.isFragmentClass(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment j02 = resourceId != -1 ? this.f9520a.j0(resourceId) : null;
        if (j02 == null && string != null) {
            j02 = this.f9520a.k0(string);
        }
        if (j02 == null && id2 != -1) {
            j02 = this.f9520a.j0(id2);
        }
        if (j02 == null) {
            j02 = this.f9520a.w0().instantiate(context.getClassLoader(), attributeValue);
            j02.mFromLayout = true;
            j02.mFragmentId = resourceId != 0 ? resourceId : id2;
            j02.mContainerId = id2;
            j02.mTag = string;
            j02.mInLayout = true;
            FragmentManager fragmentManager = this.f9520a;
            j02.mFragmentManager = fragmentManager;
            j02.mHost = fragmentManager.z0();
            j02.onInflate(this.f9520a.z0().f(), attributeSet, j02.mSavedFragmentState);
            x10 = this.f9520a.j(j02);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Fragment " + j02 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (j02.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
            }
            j02.mInLayout = true;
            FragmentManager fragmentManager2 = this.f9520a;
            j02.mFragmentManager = fragmentManager2;
            j02.mHost = fragmentManager2.z0();
            j02.onInflate(this.f9520a.z0().f(), attributeSet, j02.mSavedFragmentState);
            x10 = this.f9520a.x(j02);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + j02 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.g(j02, viewGroup);
        j02.mContainer = viewGroup;
        x10.m();
        x10.j();
        View view2 = j02.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (j02.mView.getTag() == null) {
            j02.mView.setTag(string);
        }
        j02.mView.addOnAttachStateChangeListener(new a(x10));
        return j02.mView;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
