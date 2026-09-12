package org.chromium.net;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.net.CronetEngine;
import org.chromium.net.DnsOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class e extends ICronetEngineBuilder {

    /* renamed from: d, reason: collision with root package name */
    private static final Set f71805d = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 3)));

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f71806a;

    /* renamed from: b, reason: collision with root package name */
    private final List f71807b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final ICronetEngineBuilder f71808c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ICronetEngineBuilder iCronetEngineBuilder) {
        this.f71808c = iCronetEngineBuilder;
    }

    private static JSONObject d(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                jSONObject.put(str, optJSONObject);
            } catch (JSONException e11) {
                throw new IllegalArgumentException("Failed adding a default object for key [" + str + "]", e11);
            }
        }
        return optJSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(ConnectionMigrationOptions connectionMigrationOptions, JSONObject jSONObject) {
        JSONObject d11 = d(jSONObject, "QUIC");
        if (connectionMigrationOptions.getEnableDefaultNetworkMigration() != null) {
            d11.put("migrate_sessions_on_network_change_v2", connectionMigrationOptions.getEnableDefaultNetworkMigration());
        }
        if (connectionMigrationOptions.getAllowServerMigration() != null) {
            d11.put("allow_server_migration", connectionMigrationOptions.getAllowServerMigration());
        }
        if (connectionMigrationOptions.getMigrateIdleConnections() != null) {
            d11.put("migrate_idle_sessions", connectionMigrationOptions.getMigrateIdleConnections());
        }
        if (connectionMigrationOptions.getIdleMigrationPeriodSeconds() != null) {
            d11.put("idle_session_migration_period_seconds", connectionMigrationOptions.getIdleMigrationPeriodSeconds());
        }
        if (connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork() != null) {
            d11.put("retry_on_alternate_network_before_handshake", connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork());
        }
        if (connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds() != null) {
            d11.put("max_time_on_non_default_network_seconds", connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds());
        }
        if (connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount() != null) {
            d11.put("max_migrations_to_non_default_network_on_path_degrading", connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount() != null) {
            d11.put("max_migrations_to_non_default_network_on_write_error", connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getEnablePathDegradationMigration() != null) {
            boolean booleanValue = connectionMigrationOptions.getEnablePathDegradationMigration().booleanValue();
            if (connectionMigrationOptions.getAllowNonDefaultNetworkUsage() != null) {
                boolean booleanValue2 = connectionMigrationOptions.getAllowNonDefaultNetworkUsage().booleanValue();
                if (!booleanValue && booleanValue2) {
                    throw new IllegalArgumentException("Unable to turn on non-default network usage without path degradation migration!");
                }
                if (booleanValue && booleanValue2) {
                    d11.put("migrate_sessions_early_v2", true);
                    return;
                }
                d11.put("migrate_sessions_early_v2", false);
            }
            d11.put("allow_port_migration", booleanValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(DnsOptions dnsOptions, JSONObject jSONObject) {
        JSONObject d11 = d(jSONObject, "AsyncDNS");
        if (dnsOptions.getUseBuiltInDnsResolver() != null) {
            d11.put(OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, dnsOptions.getUseBuiltInDnsResolver());
        }
        JSONObject d12 = d(jSONObject, "StaleDNS");
        if (dnsOptions.getEnableStaleDns() != null) {
            d12.put(OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, dnsOptions.getEnableStaleDns());
        }
        if (dnsOptions.getPersistHostCache() != null) {
            d12.put("persist_to_disk", dnsOptions.getPersistHostCache());
        }
        if (dnsOptions.getPersistHostCachePeriodMillis() != null) {
            d12.put("persist_delay_ms", dnsOptions.getPersistHostCachePeriodMillis());
        }
        if (dnsOptions.getStaleDnsOptions() != null) {
            DnsOptions.StaleDnsOptions staleDnsOptions = dnsOptions.getStaleDnsOptions();
            if (staleDnsOptions.getAllowCrossNetworkUsage() != null) {
                d12.put("allow_other_network", staleDnsOptions.getAllowCrossNetworkUsage());
            }
            if (staleDnsOptions.getFreshLookupTimeoutMillis() != null) {
                d12.put("delay_ms", staleDnsOptions.getFreshLookupTimeoutMillis());
            }
            if (staleDnsOptions.getUseStaleOnNameNotResolved() != null) {
                d12.put("use_stale_on_name_not_resolved", staleDnsOptions.getUseStaleOnNameNotResolved());
            }
            if (staleDnsOptions.getMaxExpiredDelayMillis() != null) {
                d12.put("max_expired_time_ms", staleDnsOptions.getMaxExpiredDelayMillis());
            }
        }
        JSONObject d13 = d(jSONObject, "QUIC");
        if (dnsOptions.getPreestablishConnectionsToStaleDnsResults() != null) {
            d13.put("race_stale_dns_on_connection", dnsOptions.getPreestablishConnectionsToStaleDnsResults());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(QuicOptions quicOptions, JSONObject jSONObject) {
        JSONObject d11 = d(jSONObject, "QUIC");
        if (!quicOptions.getQuicHostAllowlist().isEmpty()) {
            d11.put("host_whitelist", org.chromium.net.a.a(",", quicOptions.getQuicHostAllowlist()));
        }
        if (!quicOptions.getEnabledQuicVersions().isEmpty()) {
            d11.put("quic_version", org.chromium.net.a.a(",", quicOptions.getEnabledQuicVersions()));
        }
        if (!quicOptions.getConnectionOptions().isEmpty()) {
            d11.put("connection_options", org.chromium.net.a.a(",", quicOptions.getConnectionOptions()));
        }
        if (!quicOptions.getClientConnectionOptions().isEmpty()) {
            d11.put("client_connection_options", org.chromium.net.a.a(",", quicOptions.getClientConnectionOptions()));
        }
        if (!quicOptions.getExtraQuicheFlags().isEmpty()) {
            d11.put("set_quic_flags", org.chromium.net.a.a(",", quicOptions.getExtraQuicheFlags()));
        }
        if (quicOptions.getInMemoryServerConfigsCacheSize() != null) {
            d11.put("max_server_configs_stored_in_properties", quicOptions.getInMemoryServerConfigsCacheSize());
        }
        if (quicOptions.getHandshakeUserAgent() != null) {
            d11.put("user_agent_id", quicOptions.getHandshakeUserAgent());
        }
        if (quicOptions.getRetryWithoutAltSvcOnQuicErrors() != null) {
            d11.put("retry_without_alt_svc_on_quic_errors", quicOptions.getRetryWithoutAltSvcOnQuicErrors());
        }
        if (quicOptions.getEnableTlsZeroRtt() != null) {
            d11.put("disable_tls_zero_rtt", !quicOptions.getEnableTlsZeroRtt().booleanValue());
        }
        if (quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds() != null) {
            d11.put("max_idle_time_before_crypto_handshake_seconds", quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds());
        }
        if (quicOptions.getCryptoHandshakeTimeoutSeconds() != null) {
            d11.put("max_time_before_crypto_handshake_seconds", quicOptions.getCryptoHandshakeTimeoutSeconds());
        }
        if (quicOptions.getIdleConnectionTimeoutSeconds() != null) {
            d11.put("idle_connection_timeout_seconds", quicOptions.getIdleConnectionTimeoutSeconds());
        }
        if (quicOptions.getRetransmittableOnWireTimeoutMillis() != null) {
            d11.put("retransmittable_on_wire_timeout_milliseconds", quicOptions.getRetransmittableOnWireTimeoutMillis());
        }
        if (quicOptions.getCloseSessionsOnIpChange() != null) {
            d11.put("close_sessions_on_ip_change", quicOptions.getCloseSessionsOnIpChange());
        }
        if (quicOptions.getGoawaySessionsOnIpChange() != null) {
            d11.put("goaway_sessions_on_ip_change", quicOptions.getGoawaySessionsOnIpChange());
        }
        if (quicOptions.getInitialBrokenServicePeriodSeconds() != null) {
            d11.put("initial_delay_for_broken_alternative_service_seconds", quicOptions.getInitialBrokenServicePeriodSeconds());
        }
        if (quicOptions.getIncreaseBrokenServicePeriodExponentially() != null) {
            d11.put("exponential_backoff_on_initial_delay", quicOptions.getIncreaseBrokenServicePeriodExponentially());
        }
        if (quicOptions.getDelayJobsWithAvailableSpdySession() != null) {
            d11.put("delay_main_job_with_available_spdy_session", quicOptions.getDelayJobsWithAvailableSpdySession());
        }
    }

    private static JSONObject h(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e11) {
            throw new IllegalArgumentException("Experimental options parsing failed", e11);
        }
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder addPublicKeyPins(String str, Set set, boolean z10, Date date) {
        this.f71808c.addPublicKeyPins(str, set, z10, date);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder addQuicHint(String str, int i11, int i12) {
        this.f71808c.addQuicHint(str, i11, i12);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ExperimentalCronetEngine build() {
        if (this.f71806a == null && this.f71807b.isEmpty()) {
            return this.f71808c.build();
        }
        if (this.f71806a == null) {
            this.f71806a = new JSONObject();
        }
        Iterator it = this.f71807b.iterator();
        while (it.hasNext()) {
            try {
                ((a) it.next()).a(this.f71806a);
            } catch (JSONException e11) {
                throw new IllegalStateException("Unable to apply JSON patch!", e11);
            }
        }
        this.f71808c.setExperimentalOptions(this.f71806a.toString());
        return this.f71808c.build();
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableBrotli(boolean z10) {
        this.f71808c.enableBrotli(z10);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableHttp2(boolean z10) {
        this.f71808c.enableHttp2(z10);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableHttpCache(int i11, long j11) {
        this.f71808c.enableHttpCache(i11, j11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean z10) {
        this.f71808c.enableNetworkQualityEstimator(z10);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z10) {
        this.f71808c.enablePublicKeyPinningBypassForLocalTrustAnchors(z10);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableQuic(boolean z10) {
        this.f71808c.enableQuic(z10);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder enableSdch(boolean z10) {
        this.f71808c.enableSdch(z10);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return this.f71808c.getDefaultUserAgent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.net.ICronetEngineBuilder
    public Set getSupportedConfigOptions() {
        return f71805d;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setConnectionMigrationOptions(final ConnectionMigrationOptions connectionMigrationOptions) {
        if (this.f71808c.getSupportedConfigOptions().contains(1)) {
            this.f71808c.setConnectionMigrationOptions(connectionMigrationOptions);
            return this;
        }
        this.f71807b.add(new a() { // from class: org.chromium.net.c
            @Override // org.chromium.net.e.a
            public final void a(JSONObject jSONObject) {
                e.e(ConnectionMigrationOptions.this, jSONObject);
            }
        });
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setDnsOptions(final DnsOptions dnsOptions) {
        if (this.f71808c.getSupportedConfigOptions().contains(2)) {
            this.f71808c.setDnsOptions(dnsOptions);
            return this;
        }
        this.f71807b.add(new a() { // from class: org.chromium.net.b
            @Override // org.chromium.net.e.a
            public final void a(JSONObject jSONObject) {
                e.f(DnsOptions.this, jSONObject);
            }
        });
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setExperimentalOptions(String str) {
        if (str == null || str.isEmpty()) {
            this.f71806a = null;
        } else {
            this.f71806a = h(str);
        }
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        this.f71808c.setLibraryLoader(libraryLoader);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setQuicOptions(final QuicOptions quicOptions) {
        if (this.f71808c.getSupportedConfigOptions().contains(3)) {
            this.f71808c.setQuicOptions(quicOptions);
            return this;
        }
        this.f71807b.add(new a() { // from class: org.chromium.net.d
            @Override // org.chromium.net.e.a
            public final void a(JSONObject jSONObject) {
                e.g(QuicOptions.this, jSONObject);
            }
        });
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setStoragePath(String str) {
        this.f71808c.setStoragePath(str);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setThreadPriority(int i11) {
        this.f71808c.setThreadPriority(i11);
        return this;
    }

    @Override // org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setUserAgent(String str) {
        this.f71808c.setUserAgent(str);
        return this;
    }
}
