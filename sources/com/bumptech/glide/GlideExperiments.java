package com.bumptech.glide;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GlideExperiments {
    private final Map<Class<?>, Experiment> experiments;

    /* loaded from: classes2.dex */
    static final class Builder {
        private final Map<Class<?>, Experiment> experiments = new HashMap();

        Builder add(Experiment experiment) {
            this.experiments.put(experiment.getClass(), experiment);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public GlideExperiments build() {
            return new GlideExperiments(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder update(Experiment experiment, boolean z10) {
            if (z10) {
                add(experiment);
            } else {
                this.experiments.remove(experiment.getClass());
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Experiment {
    }

    GlideExperiments(Builder builder) {
        this.experiments = Collections.unmodifiableMap(new HashMap(builder.experiments));
    }

    @Nullable
    <T extends Experiment> T get(Class<T> cls) {
        return (T) this.experiments.get(cls);
    }

    public boolean isEnabled(Class<? extends Experiment> cls) {
        return this.experiments.containsKey(cls);
    }
}
