package ma.uir.club.service;

import java.util.List;
import javax.persistence.criteria.JoinType;
import ma.uir.club.domain.*; // for static metamodels
import ma.uir.club.domain.Meeting;
import ma.uir.club.repository.MeetingRepository;
import ma.uir.club.service.criteria.MeetingCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Meeting} entities in the database.
 * The main input is a {@link MeetingCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Meeting} or a {@link Page} of {@link Meeting} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class MeetingQueryService extends QueryService<Meeting> {

    private final Logger log = LoggerFactory.getLogger(MeetingQueryService.class);

    private final MeetingRepository meetingRepository;

    public MeetingQueryService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    /**
     * Return a {@link List} of {@link Meeting} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Meeting> findByCriteria(MeetingCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Meeting> specification = createSpecification(criteria);
        return meetingRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Meeting} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Meeting> findByCriteria(MeetingCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Meeting> specification = createSpecification(criteria);
        return meetingRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(MeetingCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Meeting> specification = createSpecification(criteria);
        return meetingRepository.count(specification);
    }

    /**
     * Function to convert {@link MeetingCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Meeting> createSpecification(MeetingCriteria criteria) {
        Specification<Meeting> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Meeting_.id));
            }
            if (criteria.getTitle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitle(), Meeting_.title));
            }
            if (criteria.getMeetingDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMeetingDate(), Meeting_.meetingDate));
            }
            if (criteria.getMeetingPlace() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMeetingPlace(), Meeting_.meetingPlace));
            }
            if (criteria.getClubId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getClubId(), root -> root.join(Meeting_.club, JoinType.LEFT).get(Club_.id))
                    );
            }
        }
        return specification;
    }
}