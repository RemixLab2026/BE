package org.woojukang.remixlab.domain.plot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.woojukang.remixlab.domain.plot.entity.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot,Integer> {
}
