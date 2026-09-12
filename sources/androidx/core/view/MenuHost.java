package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.view.Lifecycle;

/* loaded from: classes.dex */
public interface MenuHost {
    void addMenuProvider(MenuProvider menuProvider);

    void addMenuProvider(MenuProvider menuProvider, androidx.view.u uVar);

    @SuppressLint({"LambdaLast"})
    void addMenuProvider(MenuProvider menuProvider, androidx.view.u uVar, Lifecycle.State state);

    void invalidateMenu();

    void removeMenuProvider(MenuProvider menuProvider);
}
