{{/* _helpers.tpl */}}

{{- define "users-posts-chart.labels.currentDate" -}}
{{- printf "%s" now | quote -}}
{{- end -}}

{{- define "users-posts-chart.labels.version" -}}
{{- .Chart.Version | quote -}}
{{- end -}}