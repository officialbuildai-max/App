package com.amazonaws.services.s3.model.analytics;

/* loaded from: classes2.dex */
public interface AnalyticsPredicateVisitor {
    void a(AnalyticsPrefixPredicate analyticsPrefixPredicate);

    void b(AnalyticsTagPredicate analyticsTagPredicate);

    void c(AnalyticsAndOperator analyticsAndOperator);
}
