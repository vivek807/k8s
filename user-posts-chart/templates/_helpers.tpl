{{/* _helpers.tpl */}}

{{- define "users-posts-chart.labels.currentDate" -}}
{{- now | date "2006-01-02" }}
{{- end -}}

{{- define "users-posts-chart.labels.version" -}}
{{- .Chart.Version | quote -}}
{{- end -}}
