package sejin.sejinspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sejin.sejinspring.repository.JdbcTemplateMemberRepository;
import sejin.sejinspring.repository.MemberRepository;
import sejin.sejinspring.repository.MemoryMemberRepository;
import sejin.sejinspring.repository.JdbcMemberRepository;
import sejin.sejinspring.service.MemberService;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
