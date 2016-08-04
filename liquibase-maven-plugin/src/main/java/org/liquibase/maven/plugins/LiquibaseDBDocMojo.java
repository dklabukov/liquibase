package org.liquibase.maven.plugins;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;

/**
 * Generates dbDocs against the database.
 *
 * @author Ryan Connolly
 * @goal dbDoc
 */
public class LiquibaseDBDocMojo extends AbstractLiquibaseChangeLogMojo {

    /**
     * @parameter
     *      expression="${liquibase.outputDirectory}"
     *      default-value="${project.build.directory}/liquibase/dbDoc"
     */
    private String outputDirectory;

    /**
     * @parameter
     *      expression="${liquibase.filter}"
     *      default-value=""
     */
    private String filter;

    @Override
    protected void performLiquibaseTask(Liquibase liquibase) throws LiquibaseException
    {
        liquibase.generateDocumentation(outputDirectory,  new Contexts(), new LabelExpression(), filter);
    }


    public String getOutputDirectory()
    {
        return outputDirectory;
    }

    public String getFilter() {
        return filter;
    }
}
