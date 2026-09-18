package com.example.app.repository;

import com.example.app.entity.DeviceTrialUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceTrialUsageRepository extends JpaRepository<DeviceTrialUsage, UUID> {

    Optional<DeviceTrialUsage> findByDeviceIdAndFeatureName(String deviceId, String featureName);

    List<DeviceTrialUsage> findByDeviceId(String deviceId);

    long countByFeatureName(String featureName);

    @Query("SELECT COUNT(DISTINCT d.deviceId) FROM DeviceTrialUsage d")
    long countDistinctDevices();

    @Query("SELECT d.featureName, SUM(d.usageCount) FROM DeviceTrialUsage d GROUP BY d.featureName")
    List<Object[]> getUsageCountByFeature();
}
