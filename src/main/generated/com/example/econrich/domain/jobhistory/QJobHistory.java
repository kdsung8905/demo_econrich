package com.example.econrich.domain.jobhistory;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJobHistory is a Querydsl query type for JobHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJobHistory extends EntityPathBase<JobHistory> {

    private static final long serialVersionUID = 1370270184L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJobHistory jobHistory = new QJobHistory("jobHistory");

    public final com.example.econrich.domain.department.QDepartment department;

    public final com.example.econrich.domain.employee.QEmployee employee;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final com.example.econrich.domain.job.QJob job;

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public QJobHistory(String variable) {
        this(JobHistory.class, forVariable(variable), INITS);
    }

    public QJobHistory(Path<? extends JobHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJobHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJobHistory(PathMetadata metadata, PathInits inits) {
        this(JobHistory.class, metadata, inits);
    }

    public QJobHistory(Class<? extends JobHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new com.example.econrich.domain.department.QDepartment(forProperty("department"), inits.get("department")) : null;
        this.employee = inits.isInitialized("employee") ? new com.example.econrich.domain.employee.QEmployee(forProperty("employee"), inits.get("employee")) : null;
        this.job = inits.isInitialized("job") ? new com.example.econrich.domain.job.QJob(forProperty("job")) : null;
    }

}

