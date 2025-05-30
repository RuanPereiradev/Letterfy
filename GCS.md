## Itens de Configuração Mapeados    

| ID   | Descrição                        | Repositório                                             | Branch padrão | Tags                |
|------|----------------------------------|---------------------------------------------------------|---------------|---------------------|
| IC01 | Código-fonte backend (Java/Spring)| https://github.com/RuanPereiradev/Letterfy              | master          | backend, spring     |
| IC02 | Arquivo de configuração do Maven  | https://github.com/RuanPereiradev/Letterfy              | master          | pom.xml, build      |
| IC03 | Dockerfile do backend             | https://github.com/RuanPereiradev/Letterfy              | master          | docker, container   |
| IC04 | docker-compose (banco de dados)   | https://github.com/RuanPereiradev/Letterfy              | master          | mysql, compose      |
| IC05 | Scripts de banco de dados         | https://github.com/RuanPereiradev/Letterfy              | master          | backup.sql, db      |
| IC06 | Documentação do projeto           | https://github.com/RuanPereiradev/Letterfy              | master          | README.md, docs     |
| IC07 | Configuração de segurança (CORS, JWT) | https://github.com/RuanPereiradev/Letterfy          | master          | security, config    |
| IC08 | Arquivo .gitignore do projeto   | https://github.com/RuanPereiradev/Letterfy              | master          | gitignore, controle |




## Controle de Mudanças via Git    
- **Marcação de Versões**:    

```bash    
  git tag \-a v1.2.0 \-m "Release: Correção de bug crítico (Issue \#123)"    
  git push origin \--tags  
```
