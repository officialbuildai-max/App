package com.google.common.collect;

import java.util.Set;

/* loaded from: classes4.dex */
public interface u3 {
    Set asRanges();

    u3 complement();

    boolean encloses(Range range);

    boolean isEmpty();

    void removeAll(u3 u3Var);
}
