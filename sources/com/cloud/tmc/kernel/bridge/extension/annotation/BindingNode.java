package com.cloud.tmc.kernel.bridge.extension.annotation;

import com.cloud.tmc.kernel.node.Scope;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Bindable
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface BindingNode {
    Class<? extends Scope> value();
}
