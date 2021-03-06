package br.com.felipezorzo.zpa.cli.sqissue

data class GenericIssueData(
        val issues: List<Issue>
)

data class Issue(
        val engineId: String = "zpa",
        val ruleId: String,
        val severity: String,
        val type: String,
        val primaryLocation: PrimaryLocation,
        private val duration: String,
        val secondaryLocations: List<SecondaryLocation>) {
    val effortMinutes: Int = Duration.toMinute(duration)
}

data class PrimaryLocation(
        val message: String,
        val filePath: String,
        val textRange: TextRange
)

data class SecondaryLocation(
        val message: String,
        val filePath: String,
        val textRange: TextRange
)

data class TextRange(
        val startLine: Int,
        val endLine: Int?,
        val startColumn: Int?,
        val endColumn: Int?
)